package com.tc.common;

/**
 * <p>返回信息顶层接口</p>
 *
 * @author puchaobo@ct.com
 * @date 2019-09-16
 */
public interface ResponseStatus {
    /**
     * 获取返回状态码
     *
     * @return java
     */
    int getCode();

    /**
     * 返回返回消息
     *
     * @return 状态消息
     */
    String getMessage();
}
