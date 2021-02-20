package com.bwf.shop.admin.mapper;


import com.bwf.shop.admin.bean.po.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Brand 品牌模块 数据访问接口
 *
 *
 *
 * */
@Repository
public interface BrandMapper {
    /**
     * 获取所有的品牌列表
     * @return  所有品牌
     * */
    List<Brand> getAllBrandList();




}
