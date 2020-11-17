package com.ct.multidatasource.jpa.second.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "xfd_supplier_info")
@EntityListeners(AuditingEntityListener.class)
@Data
public class SecondaryEntity extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * `supplier_no`
     * 供应商编号
     */
    @Column(name = "supplier_no")
    private String supplierNo;
//    /**
//     * `supplier_name`
//     * 供应商名称
//     */
//    private String supplierName;
//    /**
//     * `contacts_name`
//     * 联系人
//     */
//    private String contactsName;
//    private String mobile;
//    private String telephone;
//    private String city;
//    private String province;
//    private String district;
//    private String loginAccount;
//    private String loginPassWord;
//    /**
//     * 供应商等级
//     */
//    private String level;
//    /**
//     * `address`
//     * '地址'
//     */
//    private String address;
//    /**
//     * `wechat`
//     * '微信'
//     */
//    private String wechat;
//    /**
//     * introduction
//     * '供应商描述'
//     */
//    private String introduction;
//    /**
//     * payMode
//     * 供应商的支付方式:0 现金结算 1 支票结算 2 线下转账
//     */
//    private Integer payMode;
//    /**
//     * payMode
//     * '供应商帐户'
//     */
//    private String payAccount;
//    /**
//     * accountPeriod
//     * '供应商帐户'
//     */
//    private String accountPeriod;
//    /**
//     * categoryId
//     * 对应xfd_qiye_user表中的cate
//     */
//    private Integer categoryId;
//    /**
//     * supplierType
//     * 1:签约 2：一般 3：美菜 4：创价网
//     */
//    private String supplierType;
//    /**
//     * isDel
//     * 0：停用     1:启用
//     */
//    private Integer isDel;
//    /**
//     * createdAt
//     */
//    private Date createdAt;
//    /**
//     * updatedAt
//     */
//    private Date updatedAt;
//    /**
//     * buyerId
//     * 采购员id
//     */
//    private String buyerId;
}
