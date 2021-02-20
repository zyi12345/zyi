package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.po.Brand;

import java.util.List;

//模块的业务接口
public interface IBrandService {
    /**
     * 获取所有的品牌列表
     * @return  所有品牌
     * */
    List<Brand> getAllBrandList();

}
