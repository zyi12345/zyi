package com.bwf.shop.admin.service;

import com.bwf.shop.admin.bean.bo.SpuAddBo;
import org.apache.ibatis.annotations.Param;

public interface ISpuService {
    /**
     * 添加商品
     *@param bo 添加商品业务模型对象
     *@return 添加商品执行是否成功
     * */
   boolean addSpu( SpuAddBo bo);
}
