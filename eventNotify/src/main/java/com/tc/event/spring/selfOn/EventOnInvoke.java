package com.tc.event.spring.selfOn;

import org.springframework.context.ApplicationEvent;

/**
 * 调用之前事件
 */
public class EventOnInvoke extends ApplicationEvent {

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EventOnInvoke(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
