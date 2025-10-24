package iNas.controller.impl;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.api.ExampleBobaApi;
import iNas.generated.model.ExampleBoba;
import iNas.service.ExampleBobaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExampleBobaApiImpl implements ExampleBobaApi {

    private final ExampleBobaService exampleBobaService;

    @Override
    public ResponseEntity<List<ExampleBoba>> getAllExampleBoba() {
        List<ExampleBoba> examples = exampleBobaService.findAllExampleBoba()
                .stream()
                .map(this::convertToApiModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(examples);
    }

    private ExampleBoba convertToApiModel(ExampleBobaEntity entity) {
        return new ExampleBoba()
                .id(entity.getId())
                .name(entity.getName());
    }
}
