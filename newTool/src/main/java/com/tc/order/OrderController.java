package com.tc.order;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 订单管理
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 根据单号获取的订单
     * @param orderNo 订单号
     * @param status 订单状态
     * @return 订单对象
     */
    @GetMapping("get")
    public OrderInfoBo getOrder(
            @RequestParam(defaultValue = "2020111111") @NotBlank String orderNo,
            @RequestParam @NotNull Integer status
    ){
        OrderInfoBo bo = new OrderInfoBo();
        bo.setOrderNo("2020111111");
        bo.setStatus(1);
        bo.setCreateDate(new Date());
        return bo;
    }

    /**
     * 创建订单
     * @param orderInfo 订单信息
     * @return 是否添加成功
     */
    @PostMapping("add")
    public OrderInfoBo add(@RequestBody @Valid OrderInfoVo orderInfo){
        OrderInfoBo bo = new OrderInfoBo();
        bo.setOrderNo("2020111111");
        bo.setStatus(1);
        bo.setCreateDate(new Date());
        return bo;
    }


}
