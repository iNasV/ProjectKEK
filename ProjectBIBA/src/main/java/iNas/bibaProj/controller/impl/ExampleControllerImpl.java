package iNas.bibaProj.controller.impl;

import iNas.bibaProj.controller.ExampleController;
import iNas.bibaProj.entity.Example;
import iNas.bibaProj.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExampleControllerImpl implements ExampleController {
    private final ExampleService exampleService;

    @Override
    public ResponseEntity<List<Example>> getAllExample() {
        var allExample = exampleService.findAllExample();
        allExample.forEach(System.out::println);
        return ResponseEntity.ok(allExample);
    }
}
