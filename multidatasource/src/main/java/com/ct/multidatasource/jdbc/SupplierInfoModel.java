package com.ct.multidatasource.jdbc;

import lombok.Data;

import java.sql.Date;

@Data
public class SupplierInfoModel {
    private Integer id;
    private String supplierNo;
    private String supplierName;
    private String contactsName;
    private String mobile;
    private String telephone;
    private String address;
    private String wechat;
    private String introduction;
    private Long payMode;
    private String payAccount;
    private String accountPeriod;
    private Integer categoryId;
    private Integer opId;
    private Long supplierType;
    private Long isDel;
    private Long downloadstatus;
    private String downloadtime;
    private String lastmsg;
    private Date createdAt;
    private Date updatedAt;
    private Integer buyerId;
    private String city;
    private String province;
    private String district;
    private String loginAccount;
    private String loginPassWord;
    private String level;

}
