package com.tc.event.spring.selfOn;

import org.springframework.context.ApplicationEvent;

/**
 * 正常返回之前事件
 */
public class EventOnResponse extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EventOnResponse(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
