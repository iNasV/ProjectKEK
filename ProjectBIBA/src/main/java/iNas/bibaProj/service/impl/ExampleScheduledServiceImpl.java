//package iNas.bibaProj.service.impl;
//
//import iNas.bibaProj.kafka.event.Event;
//import iNas.bibaProj.kafka.producer.EventProducer;
//import iNas.bibaProj.service.ExampleScheduledService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class ExampleScheduledServiceImpl implements ExampleScheduledService {
//    private final EventProducer<Event> producer;
//
//    @Override
//    public void sendEvent() {
//        Event event = Event.newBuilder()
//                .setUuid("00000000-test-test-test-000000000000")
//                .setSubject("Subject")
//                .setDescription("Description").build();
//        producer.produce(event);
//    }
//}