package iNas.kafka.consumer;

import iNas.kafka.handler.EventHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleEventListener<Event> {

    private final List<EventHandler<Event>> eventHandlers;

    @KafkaListener(topics = "events", groupId = "event-group")
    public void consume(ConsumerRecord<String, Event> event) {
        log.info("Обрабатывается сообщение из топика: " + event.topic() +
                ", offset: " + event.offset() + ", key: " + event.key());

        for (EventHandler<Event> handler : eventHandlers) {
            if (handler.isHandle(event.value())) {

                log.info("Обрабатывается сообщение из топика: " + event.topic() +
                        ", offset: " + event.offset() + ", key: " + event.key() + ", обработчиком: " + handler.toString());
                handler.handle(event.value());
            }
        }
    }

}
