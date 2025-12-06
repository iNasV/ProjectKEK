package iNas.bibaProj.service.impl;

import iNas.bibaProj.entity.Example;
import iNas.bibaProj.repository.ExampleRepository;
import iNas.bibaProj.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {
    private final ExampleRepository exampleRepository;

    @Override
    public List<Example> findAllExample() {
        return exampleRepository.findAll();
    }

    @Override
    @Transactional
    public Example saveExample(String description) {
        Example example = Example.builder()
                .name(description)
                .build();
        return exampleRepository.save(example);
    }
}
