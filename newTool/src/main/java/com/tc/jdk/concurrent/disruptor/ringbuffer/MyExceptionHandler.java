package com.tc.jdk.concurrent.disruptor.ringbuffer;

import com.lmax.disruptor.ExceptionHandler;

public class MyExceptionHandler implements ExceptionHandler{
	@Override
    public void handleEventException(Throwable ex, long sequence, Object event) {}
    @Override
    public void handleOnStartException(Throwable ex) {}
    @Override
    public void handleOnShutdownException(Throwable ex) {}

}
