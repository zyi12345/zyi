package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.po.SpuAttrKey;
import com.bwf.shop.admin.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// SpuAttrValue业务逻辑接口
public interface ISpuAttrValueService {
    /**
     * 根据属性键编号获取属性值列表
     * @param attr_key_id 属性键编号
     * @return  属性值列表
     * */

    List<SpuAttrValue>
    getSpuAttrValueListByAttrKeyId( Integer attr_key_id);

}
