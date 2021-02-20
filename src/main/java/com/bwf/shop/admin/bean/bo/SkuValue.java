package com.bwf.shop.admin.bean.bo;

import org.springframework.web.multipart.MultipartFile;

//规格值业务模型对象
public class SkuValue {
    private String sku_value_image; // 规格值图片路径
    private MultipartFile sku_value_img; //规格值图片
    private String getsku_value_text; //规格值文本
    private Double sku_value_price; //规格值增加

    public String getSku_value_image() {
        return sku_value_image;
    }

    public void setSku_value_image(String sku_value_image) {
        this.sku_value_image = sku_value_image;
    }

    public MultipartFile getSku_value_img() {
        return sku_value_img;
    }

    public void setSku_value_img(MultipartFile sku_value_img) {
        this.sku_value_img = sku_value_img;
    }

    public String getGetsku_value_text() {
        return getsku_value_text;
    }

    public void setGetsku_value_text(String getsku_value_text) {
        this.getsku_value_text = getsku_value_text;
    }

    public Double getSku_value_price() {
        return sku_value_price;
    }

    public void setSku_value_price(Double sku_value_price) {
        this.sku_value_price = sku_value_price;
    }
}
