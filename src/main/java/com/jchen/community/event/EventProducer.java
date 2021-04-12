package com.jchen.community.event;

import com.alibaba.fastjson.JSONObject;
import com.jchen.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 事件的生产者，将事件发布到指定主题
 * @Auther: jchen
 * @Date: 2021/04/01/12:19
 */
@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //处理事件
    public void fireEvent(Event event) {
        //将事件发布到指定的主题
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));

    }

}
