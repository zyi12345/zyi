package com.bwf.shop.admin.mapper;

import com.bwf.shop.admin.bean.po.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Category 商品分类模块， 数据访问层，接口
 *
 * */
@Repository
public interface CategoryMapper {

    /**
     *根据父级分类编号查询分类列表
     *@param  parent_id 父级分类编号
     *@return 父级分类的所有下属分类列表
     *
     * */
    List<Category> getCategoryListByParentId(@Param("parent_id") Integer parent_id);


}
