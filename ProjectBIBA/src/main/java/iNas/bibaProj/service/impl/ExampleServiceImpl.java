package iNas.service.impl;

import iNas.entity.Example;
import iNas.repository.ExampleRepository;
import iNas.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {
    private final ExampleRepository exampleRepository;

    @Override
    public List<Example> findAllExample() {
        return exampleRepository.findAll();
    }
}
