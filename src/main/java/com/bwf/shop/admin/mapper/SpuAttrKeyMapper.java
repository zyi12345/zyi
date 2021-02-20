package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.SpuAttrKey;
import org.springframework.stereotype.Repository;

import java.util.List;

//SpuAttrKey属性键 数据访问层接口
@Repository
public interface SpuAttrKeyMapper {
    /**
    * 获取所有的属性键列表
    * @return 所有的属性键列表
    * */
    List<SpuAttrKey> getAllSpuAttrKeyList();


}
