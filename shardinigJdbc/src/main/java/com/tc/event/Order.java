package com.tc.event;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_order")
@DynamicUpdate//批量更新
@org.hibernate.annotations.Table(appliesTo = "t_order", comment = "t_order")
public class Order implements Serializable {
    /**
     * 
     */
    @Id
    private Long id;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private Long memberId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 订单状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}