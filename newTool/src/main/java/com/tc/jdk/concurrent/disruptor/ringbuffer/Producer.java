package com.tc.jdk.concurrent.disruptor.ringbuffer;

import com.lmax.disruptor.RingBuffer;

public class Producer {
	private final RingBuffer<Order> ringBuffer;
	
    public Producer(RingBuffer<Order> ringBuffer){
        this.ringBuffer = ringBuffer;
    }
    
    public void produceData(String data){
        // 返回下一个序列
        long sequence = ringBuffer.next();
        try {
            // 返回序列上的事件
            Order order = ringBuffer.get(sequence);
            order.setId(data);
        } finally {
            // 发布序列，后序列上的事件就可以被读取了
            ringBuffer.publish(sequence);
        }
    }

}
