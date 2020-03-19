package com.example.bb.common.service;

/**
 * @author BB
 * Create: 2020/3/16 0016 22:12
 */
public interface SendMessageService<E> {

    /**
     * 发送
     *
     * @param message 消息内容
     * @return true:发送成功, false:发送失败
     */
    boolean send(E message);


}
