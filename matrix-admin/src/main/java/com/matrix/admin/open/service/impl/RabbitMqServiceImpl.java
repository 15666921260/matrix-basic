package com.matrix.admin.open.service.impl;

import com.matrix.admin.open.service.RabbitMqService;
import com.matrix.common.enums.open.TypeStr;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuweizhong
 * @since 2025-03-05 22:32
 */
@Slf4j
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String baseProducer(TypeStr stuId) {
        switch (stuId) {
            case STU -> log.info("send message to queue1");
            case COURSE -> log.info("send message to queue2");
            case TEACHER -> log.info("send message to queue3");
            default -> log.info("send message to default queue");
        }

        return null;
    }
}
