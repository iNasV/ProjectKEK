package iNas.controller.impl;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.api.ExampleBobaApi;
import iNas.generated.model.ExampleBoba;
import iNas.service.ExampleBobaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExampleBobaApiImpl implements ExampleBobaApi {

//    private final TraceService traceService;
    private final ExampleBobaService exampleBobaService;

    @Override
//    @NewSpan("bobaProcess-inControl")
    public ResponseEntity<List<ExampleBoba>> getAllExampleBoba() {
        List<ExampleBoba> examples = exampleBobaService.findAllExampleBoba();

//        return traceService.trace("boba-inProcess", ()-> {
//            logger.info("REQUEST INTO BOBA SERVICE");
//            return ResponseEntity.ok(examples);
//        });

        return ResponseEntity.ok(examples);
    }


}
