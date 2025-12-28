package iNas.bibaProj.controller.impl;

import iNas.bibaProj.controller.ExampleController;
import iNas.bibaProj.entity.Example;
import iNas.bibaProj.service.ExampleService;
import iNas.bibaProj.util.TraceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ExampleControllerImpl implements ExampleController {
    private final ExampleService exampleService;
    private final TraceUtil traceUtil;
    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<Example>> getAllExample() {

        log.warn("WARNING - биба вызывает бобу");
        Example[] array = traceUtil.trace("Внешний вызов от бибы к бобе", () -> {
            return restTemplate.getForObject("http://boba:7778", Example[].class);
        });
        log.warn("Успех вызова бибой бобы, получено {} записей!", array.length);

        List<Example> allExample = traceUtil.trace("inside Biba call", exampleService::findAllExample);

        return ResponseEntity.ok(allExample);
    }

    @Override
    public ResponseEntity<Example> saveExample(String description) {
        log.info("Информация: создается биба в биба-сервис");
        Example example = traceUtil.trace("inside Biba save", () -> {
            return exampleService.saveExample(description);
        });

        return ResponseEntity.ok(example);
    }
}
