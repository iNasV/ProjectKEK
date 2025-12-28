package iNas.controller.impl;

import iNas.generated.api.ExampleBobaApi;
import iNas.generated.model.ExampleBoba;
import iNas.service.ExampleBobaService;
import iNas.util.TraceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExampleBobaApiImpl implements ExampleBobaApi {
    private final TraceUtil traceUtil;
    private final ExampleBobaService exampleBobaService;

    @Override
    public ResponseEntity<List<ExampleBoba>> getAllExampleBoba() {
        log.debug("В боба приложении вызвалась ручка получения всех записей: localDateTime = {}", LocalDateTime.now());

        List<ExampleBoba> examples = traceUtil.trace("inside Boba call", exampleBobaService::findAllExampleBoba);

        return ResponseEntity.ok(examples);
    }
}