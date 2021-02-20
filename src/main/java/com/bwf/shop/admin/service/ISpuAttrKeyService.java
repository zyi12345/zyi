package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.po.SpuAttrKey;

import java.util.List;
// SpuAttrKey业务逻辑接口
public interface ISpuAttrKeyService {
    /**
     * 获取所有的属性键列表
     * @return 所有的属性键列表
     * */
    List<SpuAttrKey> getAllSpuAttrKeyList();
}
