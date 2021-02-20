package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import com.bwf.shop.admin.mapper.SpuAttrKeyMapper;
import com.bwf.shop.admin.mapper.SpuAttrValueMapper;
import com.bwf.shop.admin.service.ISpuAttrKeyService;
import com.bwf.shop.admin.service.ISpuAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpuAttrValueService implements ISpuAttrValueService {
    @Resource
    private SpuAttrValueMapper spuAttrValueMapper;


    @Override
    public List<SpuAttrValue> getSpuAttrValueListByAttrKeyId(Integer attr_key_id) {
        return spuAttrValueMapper.getSpuAttrValueListByAttrKeyId(attr_key_id);
    }
}