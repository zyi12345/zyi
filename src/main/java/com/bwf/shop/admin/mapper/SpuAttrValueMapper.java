package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.SpuAttrValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// SpuAttrValue 属性值模块数据访间层
@Repository
public interface SpuAttrValueMapper {
    /**
     * 根据属性键编号获取局性值列表
     *
     *
     * */

    List<SpuAttrValue>
    getSpuAttrValueListByAttrKeyId(@Param("attr_key_id") Integer attr_key_id);

    /**
     *添加商品属性值关联
     * @param spu_id 商品编号
     * @param spuAttrValueList 商品属性值列表
     **/

    int addSpuAttrValueRelations(@Param("spu_id")Integer spu_id,
                                 @Param("spuAttrValueList")List<SpuAttrValue> spuAttrValueList);


}
