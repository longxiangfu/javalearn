package com.tc.common;

/**
 * <p>常用返回状态枚举</p>
 *
 * @author puchaobo@ct.com
 * @date 2019-09-16
 */
public enum ResponseStatusEnum implements ResponseStatus {
    /**
     * 客户端异常
     */
    CLIENT_EXCEPTION(10000, "客户端异常"),
    /**
     * 请求超时
     */
    CLIENT_TIMEOUT(10001, "请求超时"),
    /**
     * 客户端解码响应数据失败
     */
    CLIENT_DECODE_EXCEPTION(10002, "客户端解码响应数据失败"),
    /**
     * 客户端编码请求数据失败
     */
    CLIENT_ENCODE_EXCEPTION(10003, "客户端编码请求数据失败"),
    /**
     * 客户端网络不可用
     */
    CLIENT_NETWORK_UNREACHABLE(10004, "客户端网络不可用"),
    /**
     * <pre>
     * 1.请求成功
     * 2.查询数据成功
     */
    OK(20000, "请求成功/数据获取成功"),
    /**
     * 新增数据成功
     */
    CREATED(20100, "数据增加成功"),
    /**
     * 已存在数据
     */
    CREATE_EXISTS(20101, "已存在数据"),
    /**
     * 更新数据成功
     */
    ACCEPTED(20200, "数据更新成功"),
    /**
     * 更新数据失败
     */
    NOT_ACCEPTED(20201, "数据更新失败"),
    /**
     * 使用乐观锁保护的数据，更新时版本不一致
     **/
    VERSION_ERROR(20202, "数据版本不一致"),
    /**
     * 请求参数有误
     */
    BAD_REQUEST(40000, "请求参数有误"),
    /**
     * 查询数据不存在
     */
    NOT_FOUND(40400, "无查询数据"),
    /**
     * 权限错误
     */
    UNAUTHORIZED(40100, "权限错误"),
    /**
     * 禁止的请求
     */
    FORBIDDEN(40300, "禁止的请求"),
    /**
     * 服务错误
     */
    SERVICE_ERROR(50000, "服务内部错误"),
    /**
     * 获取token成功
     */
    TOKEN_GET_OK(60000, "获取token成功"),
    /**
     * 获取token失败
     */
    TOKEN_GET_ERROR(60001, "获取token失败"),
    /**
     * token不存在
     */
    TOKEN_NOT_EXISTS(60002, "token不存在"),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(1000000, "未知错误");
    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ResponseStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
