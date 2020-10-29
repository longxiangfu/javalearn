package com.tc.event.spring.selfOn;

import org.springframework.context.ApplicationEvent;

/**
 * 正常返回之前事件
 */
public class OnResponse extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OnResponse(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
