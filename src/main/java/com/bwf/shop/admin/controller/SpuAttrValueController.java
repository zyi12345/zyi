package com.bwf.shop.admin.controller;

import com.alibaba.fastjson.JSON;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import com.bwf.shop.admin.service.ISpuAttrValueService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/spuAttValue")
@ResponseBody
public class SpuAttrValueController {
    @Resource
    private ISpuAttrValueService spuAttrValueService;
    @RequestMapping("/getAttrValueListByAttrKeyId")
    public String  getSpuAttrValueListByAttrKeyId(  Integer attr_key_id){
        List<SpuAttrValue> spuAttrValueList = spuAttrValueService.getSpuAttrValueListByAttrKeyId(attr_key_id);


        return JSON.toJSONString(spuAttrValueList);




    }




}
