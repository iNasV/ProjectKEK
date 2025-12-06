package iNas.controller.impl;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.api.ExampleBobaApi;
import iNas.generated.model.ExampleBoba;
import iNas.metrics.TraceService;
import iNas.service.ExampleBobaService;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExampleBobaApiImpl implements ExampleBobaApi {

    private static final Logger logger = LoggerFactory.getLogger(ExampleBobaApiImpl.class);
    private final TraceService traceService;
    private final ExampleBobaService exampleBobaService;

    @Override
    @NewSpan("bobaProcess-inControl")
    public ResponseEntity<List<ExampleBoba>> getAllExampleBoba() {
        List<ExampleBoba> examples = exampleBobaService.findAllExampleBoba()
                .stream()
                .map(this::convertToApiModel)
                .collect(Collectors.toList());

        return traceService.trace("boba-inProcess", ()-> {
            logger.info("REQUEST INTO BOBA SERVICE");
            return ResponseEntity.ok(examples);
        });
    }

    private ExampleBoba convertToApiModel(ExampleBobaEntity entity) {
        return new ExampleBoba()
                .id(entity.getId())
                .name(entity.getName());
    }
}
