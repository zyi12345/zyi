package com.bwf.shop.admin.service;
// Category 商品分类模块 业务接口

import com.bwf.shop.admin.bean.po.Category;

import java.util.List;

public interface ICategoryService {
    /**
     *根据父级分类编号查询分类列表
     *@param  parent_id 父级分类编号
     *@return 父级分类的所有下属分类列表
     *
     * */
    List<Category> getCategoryListByParentId(Integer parent_id);


}
