package iNas.bibaProj.controller.impl;

import iNas.bibaProj.controller.ExampleController;
import iNas.bibaProj.entity.Example;
import iNas.bibaProj.service.ExampleService;
import io.micrometer.core.instrument.MeterRegistry;
//import io.micrometer.tracing.annotation.NewSpan;
//import iNas.bibaProj.service.impl.TraceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ExampleControllerImpl implements ExampleController {
    private final ExampleService exampleService;
//    private static final Logger logger = LoggerFactory.getLogger(ExampleControllerImpl.class);
//    private final TraceService traceService;
//    private final RestTemplate template;
//    private final MeterRegistry registry;

    @Override
//    @NewSpan("biba-custom")
    public ResponseEntity<List<Example>> getAllExample() {



        log.warn("WARNING - биба вызывал бы бобу");
//        traceService.trace("Процесс вызова бобы", ()-> {
//            var forObject = template.getForObject("http://BOBA:8080", String.class);
//            logger.info("боба передал бибе {}", forObject);
//        });

        var allExample = exampleService.findAllExample();
        return ResponseEntity.ok(allExample);

//        return traceService.trace("getBiba-process", ()-> {
//            logger.info("biba DONE");
//            return ResponseEntity.ok(allExample);
//        });
    }

    @Override
    public ResponseEntity<Example> saveExample(String description) {
        log.info("Информация: создается биба в биба-сервис");
        Example example = exampleService.saveExample(description);
        return ResponseEntity.ok(example);
    }
}
