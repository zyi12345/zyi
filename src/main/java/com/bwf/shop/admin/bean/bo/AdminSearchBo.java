package com.bwf.shop.admin.bean.bo;
//员工搜索业务，模型对象
public class AdminSearchBo {
    private Integer admin_id;//要查询员工编号
    private String admin_name;//要查询的账户名称
    private String admin_nickname ;//要查询的员工昵称
    private Integer role_id;//要查询的角色名称
    private Integer start;//记录起始的索引
    private Integer length;//记录要查询的记录数量

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_nickname() {
        return admin_nickname;
    }

    public void setAdmin_nickname(String admin_nickname) {
        this.admin_nickname = admin_nickname;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
