package com.bwf.shop.admin.service.impl;

import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.mapper.SpuAttrKeyMapper;
import com.bwf.shop.admin.service.ISpuAttrKeyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SpuAttrKeyService implements ISpuAttrKeyService {
    @Resource
    private SpuAttrKeyMapper spuAttrKeyMapper;


    @Override
    public List<SpuAttrKey> getAllSpuAttrKeyList() {


        return spuAttrKeyMapper.getAllSpuAttrKeyList();
    }
}