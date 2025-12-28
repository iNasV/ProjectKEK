package iNas.kafka.handler;

import com.projectkek.avro.Event;
import iNas.generated.model.ExampleBoba;
import iNas.service.ExampleBobaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExampleEventHandler implements EventHandler<Event> {

    private final ExampleBobaService bobaService;

    @Override
    public boolean isHandle(Event event) {
        return true;
    }

    @Override
    public void handle(Event event) {

        MDC.put("uid", event.getUuid());
        MDC.put("subject", event.getSubject());
        MDC.put("description", event.getDescription());

        ExampleBoba boba = new ExampleBoba()
                .id(UUID.fromString(event.getUuid()))
                .name(event.getSubject() + event.getUuid());
        bobaService.saveExampleBoba(boba);
    }
}
