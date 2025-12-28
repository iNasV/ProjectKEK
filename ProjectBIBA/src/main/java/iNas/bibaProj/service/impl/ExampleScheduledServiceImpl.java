package iNas.bibaProj.service.impl;

import com.projectkek.avro.Event;
import iNas.bibaProj.kafka.producer.EventProducer;
import iNas.bibaProj.service.ExampleScheduledService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExampleScheduledServiceImpl implements ExampleScheduledService {
    private final EventProducer<Event> producer;

    @Override
    @Scheduled(fixedRateString = "${event.generation.interval-ms}")
    public void sendEvent() {
        Event event = Event.newBuilder()
                .setUuid(UUID.randomUUID().toString())
                .setSubject("Subject")
                .setDescription("Description").build();
        log.info("Планируется продюссирование события {}", event.getUuid());
        producer.produce(event);
    }
}