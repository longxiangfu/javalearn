package com.tc.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>用于各个服务数据传输统一响应结构</p>
 *
 * @author puchaobo@ct.com
 * @date 2019-10-10
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ResponseDTO<T> implements Serializable {
    static final long serialVersionUID = -8531884046266912382L;

    private Integer code;

    private String message;

    private T data;

    /**
     * <p>返回信息实例工厂</p>
     *
     * @author puchaobo@ct.com
     * @date 2020-03-07 17:11:56
     */
    public static final class Factory {

        public static <T> ResponseDTO<T> getInstance(final ResponseStatus status) {
            if (null == status) {
                throw new IllegalArgumentException();
            }

            return ResponseDTO.<T>builder()
                    .code(status.getCode())
                    .message(status.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> getInstance(final ResponseStatus status, final T data) {
            if (null == status) {
                throw new IllegalArgumentException();
            }

            return ResponseDTO.<T>builder()
                    .code(status.getCode())
                    .message(status.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> clientException() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CLIENT_EXCEPTION.getCode())
                    .message(ResponseStatusEnum.CLIENT_EXCEPTION.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> clientTimeout() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CLIENT_TIMEOUT.getCode())
                    .message(ResponseStatusEnum.CLIENT_TIMEOUT.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> clientDecodeException() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CLIENT_DECODE_EXCEPTION.getCode())
                    .message(ResponseStatusEnum.CLIENT_DECODE_EXCEPTION.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> clientEncodeException() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CLIENT_ENCODE_EXCEPTION.getCode())
                    .message(ResponseStatusEnum.CLIENT_ENCODE_EXCEPTION.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> clientNetworkUnreachable() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CLIENT_NETWORK_UNREACHABLE.getCode())
                    .message(ResponseStatusEnum.CLIENT_NETWORK_UNREACHABLE.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> ok() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.OK.getCode())
                    .message(ResponseStatusEnum.OK.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> ok(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.OK.getCode())
                    .message(ResponseStatusEnum.OK.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> created() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CREATED.getCode())
                    .message(ResponseStatusEnum.CREATED.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> created(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CREATED.getCode())
                    .message(ResponseStatusEnum.CREATED.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> createdExists() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CREATE_EXISTS.getCode())
                    .message(ResponseStatusEnum.CREATE_EXISTS.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> createdExists(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.CREATE_EXISTS.getCode())
                    .message(ResponseStatusEnum.CREATE_EXISTS.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> accepted() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.ACCEPTED.getCode())
                    .message(ResponseStatusEnum.ACCEPTED.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> accepted(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.ACCEPTED.getCode())
                    .message(ResponseStatusEnum.ACCEPTED.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> notAccepted() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.NOT_ACCEPTED.getCode())
                    .message(ResponseStatusEnum.NOT_ACCEPTED.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> notAccepted(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.NOT_ACCEPTED.getCode())
                    .message(ResponseStatusEnum.NOT_ACCEPTED.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> versionError() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.VERSION_ERROR.getCode())
                    .message(ResponseStatusEnum.VERSION_ERROR.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> badRequest() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.BAD_REQUEST.getCode())
                    .message(ResponseStatusEnum.BAD_REQUEST.getMessage())
                    .build();
        }


        public static <T> ResponseDTO<T> badRequest(T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.BAD_REQUEST.getCode())
                    .message(ResponseStatusEnum.BAD_REQUEST.getMessage())
                    .data(data)
                    .build();
        }


        public static <T> ResponseDTO<T> unauthorized() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.UNAUTHORIZED.getCode())
                    .message(ResponseStatusEnum.UNAUTHORIZED.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> forbidden(String... messages) {
            StringBuilder extStringBuilder = new StringBuilder();
            for (String msg : messages) {
                if (!StringUtils.isEmpty(extStringBuilder.toString())) {
                    extStringBuilder.append("|");
                }
                extStringBuilder.append(msg);
            }
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.FORBIDDEN.getCode())
                    .message(ResponseStatusEnum.FORBIDDEN.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> notFound(String... messages) {
            StringBuilder extStringBuilder = new StringBuilder();
            for (String msg : messages) {
                if (!StringUtils.isEmpty(extStringBuilder.toString())) {
                    extStringBuilder.append("|");
                }
                extStringBuilder.append(msg);
            }
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.NOT_FOUND.getCode())
                    .message(ResponseStatusEnum.NOT_FOUND.getMessage().concat(":").concat(extStringBuilder.toString()))
                    .build();
        }

        public static <T> ResponseDTO<T> serviceError() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.SERVICE_ERROR.getCode())
                    .message(ResponseStatusEnum.SERVICE_ERROR.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> serviceError(final String message) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.SERVICE_ERROR.getCode())
                    .message(Objects.nonNull(message) ? message : ResponseStatusEnum.SERVICE_ERROR.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> unknownError(final Throwable throwable) {
            final String message
                    = Objects.isNull(throwable) ? ResponseStatusEnum.UNKNOWN_ERROR.getMessage() : throwable.getMessage();
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.UNKNOWN_ERROR.getCode())
                    .message(message)
                    .build();
        }

        public static <T> ResponseDTO<T> tokenGetOk() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.TOKEN_GET_OK.getCode())
                    .message(ResponseStatusEnum.TOKEN_GET_OK.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> tokenGetOk(final T data) {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.TOKEN_GET_OK.getCode())
                    .message(ResponseStatusEnum.TOKEN_GET_OK.getMessage())
                    .data(data)
                    .build();
        }

        public static <T> ResponseDTO<T> tokenGetError() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.TOKEN_GET_ERROR.getCode())
                    .message(ResponseStatusEnum.TOKEN_GET_ERROR.getMessage())
                    .build();
        }

        public static <T> ResponseDTO<T> tokenNotExists() {
            return ResponseDTO.<T>builder()
                    .code(ResponseStatusEnum.TOKEN_NOT_EXISTS.getCode())
                    .message(ResponseStatusEnum.TOKEN_NOT_EXISTS.getMessage())
                    .build();
        }
    }

}
