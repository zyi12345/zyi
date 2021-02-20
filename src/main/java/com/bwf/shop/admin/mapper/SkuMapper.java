package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.bo.SkuAddBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//
@Repository
public interface SkuMapper {
    /**
     * 添加商品的规格列表
     *@param spu_id 要添 加规格的商品的商品编号
     *@param skuAddBoList 规格业务模型列表
     *
     *@return  数据库受到影响的行数
     *
     *
     * */
    int addSpuSkuList(@Param("spu_id" ) Integer spu_id,
                      @Param("skuAddBoList" ) List<SkuAddBo> skuAddBoList) ;

}
