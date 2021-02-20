package com.bwf.shop.admin.controller;

import com.alibaba.fastjson.JSON;
import com.bwf.shop.admin.bean.bo.SkuAddBo;
import com.bwf.shop.admin.bean.bo.SkuValue;
import com.bwf.shop.admin.bean.bo.SpuAddBo;
import com.bwf.shop.admin.bean.bo.SpuBannerAddBo;
import com.bwf.shop.admin.bean.po.Category;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import com.bwf.shop.admin.service.IBrandService;
import com.bwf.shop.admin.service.ICategoryService;
import com.bwf.shop.admin.service.ISpuAttrKeyService;
import com.bwf.shop.admin.service.ISpuService;
import com.bwf.shop.admin.service.impl.SpuAttrKeyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/spu")
public class SpuController {
    // brand 品牌业务
   @Resource
   private IBrandService brandService;

    //category 分类业务
   @Resource
   private ICategoryService categoryService;

   //属性键
   @Resource
   private ISpuAttrKeyService spuAttrKeyService;

   //执行添加商品业务
    @Resource
    private ISpuService spuService;



    //商品管理页面分类
@RequestMapping("/admin")
public String admin(){



    return null;
}

//添加商品表单
@RequestMapping("/add")
public String add(Model model){
    //获取所有品牌
    model.addAttribute("brandList",brandService.getAllBrandList());

  //获取所有一级分类

    model.addAttribute("categoryList",categoryService.getCategoryListByParentId(null));
    //获取所有的属性键
    model.addAttribute("spuAttrKeyList",spuAttrKeyService.getAllSpuAttrKeyList());

    return null;

    }
    //二级联动提交的路径
    @RequestMapping("/getCategoryListByParentId")
    @ResponseBody
    public String getCategoryListByParentId(Integer parent_id){
        List<Category> categoryList = categoryService.getCategoryListByParentId(parent_id);
        String json = JSON.toJSONString(categoryList);
        return json;


    }
    //添加商品执行
    @RequestMapping("/save")
    public String save(SpuAddBo bo,Model model){
        System.out.println(" ************开始添加商品*************");
        System.out.println("**商品名称="+bo.getSpu_name());
        System.out.println("**商品标题="+bo.getSpu_title());
        System.out.println("**商品起价="+bo.getSpu_price());
        System.out.println("**商品库存="+bo.getSpu_stock());
        System.out.println("**预警库存="+bo.getSpu_warningstock());
        System.out.println("**购买数量="+bo.getSpu_maxbuy());
        System.out.println("**商品单位="+bo.getSpu_unit());
        System.out.println("**商品状态="+bo.getSpu_status());
        System.out.println("**品牌编号="+bo.getSpu_brand_id());
        System.out.println("**分类编号="+bo.getSpu_category_id());
        System.out.println("**商品介绍="+bo.getSpu_introduction());
        //业务流程 给当前添加的商品  生成创建时间和更新时间
        bo. setCreatetime (new Date(System . currentTimeMillis()));
        bo. setUpdatetime (new Date(System . currentTimeMillis()));
        System.out.println("**创建时间=" + bo. getCreatetime());
        System.out.println("**更新时间="+ bo.getUpdatetime());
        //业务流程上传图片 随机序列号 UUID
        UUID uuid = UUID.randomUUID();
        //上传服务器端的文件名
        String spu_img_name= uuid.toString()+bo.getSpu_thumburl_img().getOriginalFilename().
                substring(bo.getSpu_thumburl_img().getOriginalFilename().lastIndexOf("."));
        //存放服务器图片static/img
        String path =null;
        try {
            //获取static/img 绝对路径 存放 上传文件的路径
            path= ResourceUtils.getURL("classpath:").getPath()+"static/img";
            //定义文件对象
            File spu_image_file = new File(path + spu_img_name);
             //将上传的封面图片，另存到static/img 路径下
            bo.getSpu_thumburl_img().transferTo(spu_image_file);
         //将上传文件的服务器存放的文件名 设置给成员属性spu_thumburl
            bo.setSpu_thumburl(spu_img_name);
            System.out.println("** 封面图片 ="+bo.getSpu_thumburl());


        } catch (IOException e) {
            e.printStackTrace();
        }
        //达代遍历所有的商品规格
        for(SkuAddBo sku : bo.getSkuAddBoList()){
            System.out.println("*******商品规格********");

            System.out.println("**规格名称=" +sku.getSku_name());
            System.out.println("**规格排序=" +sku.getSortno());
          //设置当前规格的创建时向和更新时间
            sku.setCreatetime(new Date (System.currentTimeMillis()));
            sku.setUpdatetime (new Date (System.currentTimeMillis()));
            System.out.println("**创建时间="+ sku.getCreatetime());
            System.out.println("更新时间="+ sku.getUpdatetime());
             //迭代遍历当前规格中所有的规格值
            for(SkuValue skuValue : sku.getSkuValueList()){
                if (!skuValue.getSku_value_img().isEmpty()){
                  uuid = UUID. randomUUID();
                    String skuvalue_image_name=uuid.toString()+skuValue.getSku_value_img()
                            .getOriginalFilename()
                            .substring(skuValue.getSku_value_img().getOriginalFilename().lastIndexOf("."));
                    File skuvalue_image_file = new File(  path + skuvalue_image_name);
                    try {
                        skuValue.getSku_value_img().transferTo(skuvalue_image_file);
                        skuValue.setSku_value_image( skuvalue_image_name) ;



                    } catch (IOException e) {
                        e. printStackTrace();
                    }



                }

                //将当前迭代到 规格值的 成员属性没置为 null ==》 转换json字符串
                skuValue.setSku_value_img(null);

                sku. setSku_spuattr(JSON.toJSONString(sku. getSkuValueList()));
                System.out.println("**规格值json字符串="+ sku.getSku_spuattr());
                System.out.println("***********添加商品完毕**********");

                //选代遍历商品中所有相册图片
                for(SpuBannerAddBo banner : bo.getSpuBannerAddBoList()) {
                    System.out.println(" ******商品相册图片**********");
                    System. out.println("**相册名称="+ banner. getSpu_banner_name());
                    banner.setCreatetime(new Date (System.currentTimeMillis()));
                    banner.setUpdatetime(new Date(System.currentTimeMillis()));
                    System. out. println(".创建时间=" +banner.getCreatetime() );
                    System. out. println("**更新时间="+banner.getUpdatetime() );
                      //为上传文件生成文件名
                    uuid = UUID.randomUUID();
                    String banner_name = uuid.toString()+banner.getSpu_banner_img()
                            .getOriginalFilename()
                            .substring(banner.getSpu_banner_img().getOriginalFilename().lastIndexOf("."));

                    File banner_file = new File(  path + banner_name);
                    try {
                       banner.getSpu_banner_img().transferTo(banner_file);

                        banner.setSpu_banner_urls(banner_name) ;
                        System. out. println("**相册图片="+ banner.getSpu_banner_urls());

                    } catch (IOException e) {
                        e. printStackTrace();
                    }

                }

                //迭代遍历商品中所有属性值
                for(SpuAttrValue attrValue : bo.getSpuAttrValueList()){
                    System.out.println("*****商品属性值******");
                    System.out.println("******属性值编号:"+attrValue.getId());


                }


                System.out.println(" *********商品添加完毕**********");
                //将添加商品业务模型对象添加到数据库
                boolean result = spuService.addSpu(bo);
                 //判断添加商品是否成功
                if(result){
                    model.addAttribute( "messages" , new String[]{" 商品添加成功!!!"});
                    model. addAttribute( "back",  "/spu/admin");
                    return "common/success";
                }else{
                    model.addAttribute("messages" ,new String[]{" 商品添加失败!!!"});
                    model.addAttribute("solution" ,"请联系管理员");
                    model.addAttribute("back",  "/spu/add");
                    return "common/error";
                }


            }


        }



        return null;

    }

}




















