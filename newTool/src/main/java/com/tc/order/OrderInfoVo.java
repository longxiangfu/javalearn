package com.tc.order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 订单Vo
 */
public class OrderInfoVo {

    /**
     * 订单号
     */
    @NotBlank
    private String orderNo;
    /**
     * 订单状态
     */
    @NotNull
    private Integer status;
    /**
     * 创建日期
     */
    @NotNull
    private Date createDate;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "OrderInfoVo{" +
                "orderNo='" + orderNo + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
