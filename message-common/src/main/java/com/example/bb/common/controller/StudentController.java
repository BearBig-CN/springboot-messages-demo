package com.example.bb.common.controller;

import com.example.bb.common.domain.Student;
import com.example.bb.common.enums.SendType;
import com.example.bb.common.service.SendMessageService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * 对外接口
 *
 * @author BB
 * Create: 2020/3/13 20:50
 */
@Slf4j
@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private SendMessageService<String> messageSenderByP2P;

    @Autowired
    private SendMessageService<Student> studentSenderByP2P;

    @Autowired
    private SendMessageService<String> messageSenderByPub;

    @Autowired
    private SendMessageService<Student> studentSenderByPub;

    @JsonAnyGetter
    @GetMapping(value = "/send/{message}", params = "sendType=p2p")
    public boolean sendMessageWithP2P(String sendType, @PathVariable String message) {
        log.info("调用了sendMessageWithP2P(), 消息发送类型是 ={}, 接收到客户端的信息是 = {}", sendType, message);
        return messageSenderByP2P.send(message);
    }

    @JsonAnyGetter
    @GetMapping(value = "/send/{message}", params = "sendType=ps")
    public boolean sendMessageWithPubSub(String sendType, @PathVariable String message) {
        log.info("调用了sendMessageWithPubSub(), 消息发送类型是 ={}, 接收到客户端的信息是 = {}", sendType, message);
        return messageSenderByPub.send(message);
    }

    @JsonAnyGetter
    @GetMapping(value = "/send/{count}/{message}")
    public boolean sendMessage(SendType sendType, @PathVariable Integer count, @PathVariable String message) {
        boolean result = false;
        log.info("调用了sendMessage(), 发送次数是 = {},接收到客户端的信息是 = {}", count, message);
        for (int i = 0; i < count; i++) {
            if (sendType.equals(SendType.P2P)) {
                result = messageSenderByP2P.send(message);
            } else {
                result = messageSenderByPub.send(message);
            }
        }
        return result;
    }


    @JsonAnyGetter
    @GetMapping(value = "/send")
    public boolean sendStudent(SendType sendType) {
        log.info("调用了sendStudent(), 消息发送类型是 ={}", sendType);
        Student stu = Student.builder()
                .stuId("1")
                .name("贝克汉姆")
                .birthday(Calendar.getInstance().getTime())
                .age(37)
                .build();
        if (SendType.P2P.equals(sendType)) {
            return studentSenderByP2P.send(stu);
        } else {
            return studentSenderByPub.send(stu);
        }
    }
}
