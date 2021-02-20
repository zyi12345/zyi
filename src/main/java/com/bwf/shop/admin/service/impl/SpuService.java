package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.bo.SpuAddBo;
import com.bwf.shop.admin.mapper.SkuMapper;
import com.bwf.shop.admin.mapper.SpuAttrValueMapper;
import com.bwf.shop.admin.mapper.SpuBannerMapper;
import com.bwf.shop.admin.mapper.SpuMapper;
import com.bwf.shop.admin.service.ISpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
//添加商品业务实现类

@Service
public class SpuService implements ISpuService {
    @Resource
    private   SpuMapper spuMapper;
    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SpuBannerMapper spuBannerMapper;
    @Resource
    private SpuAttrValueMapper spuAttrValueMapper;



    @Override
    @Transactional
    public boolean addSpu(SpuAddBo bo) {
        //将商品业务模型对象添加到spu商品表,产生商品编号id
       int a= spuMapper.addSpu(bo);
         //添加规格列表
        int b = skuMapper.addSpuSkuList(bo.getId(), bo. getSkuAddBoList());
        //商品相册列表
        int c = spuBannerMapper.addSpuBannerList (bo.getId(),bo.getSpuBannerAddBoList());

        //添加商品属性关联列表
        int d = spuAttrValueMapper.addSpuAttrValueRelations(bo.getId(),bo.getSpuAttrValueList());


        return a>0;
    }
}
