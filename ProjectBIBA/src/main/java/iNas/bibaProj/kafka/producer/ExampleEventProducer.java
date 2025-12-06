//package iNas.bibaProj.kafka.producer;
//
//import iNas.bibaProj.kafka.event.Event;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CompletableFuture;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class ExampleEventProducer implements EventProducer<Event> {
//    private final KafkaTemplate<String, Event> kafkaTemplate;
//
//    @Value("${event.topic}")
//    private String topic;
//
//    @Override
//    public void produce(Event event) {
//        if (event==null) {
//            throw new IllegalArgumentException("Попытка отправить пустое событие в продюсере");
//        }
//
//        CompletableFuture<SendResult<String,Event>> future = kafkaTemplate.send(topic, event);
//        future.whenComplete((result,exception) -> {
//            if (exception != null) {
//                log.error("Ошибка при отправке события: {}", exception.getMessage(), exception);
//            } else {
//                log.info("Событие {} доставлено успешно. Таймстамп: {}, Партиция: {}",
//                        event.getUuid(),
//                        result.getRecordMetadata().timestamp(),
//                        result.getRecordMetadata().partition());
//            }
//        });
//    }
//}