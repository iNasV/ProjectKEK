package iNas.service.impl;

import iNas.entity.ExampleBobaEntity;
import iNas.repository.ExampleBobaRepository;
import iNas.service.ExampleBobaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleBobaServiceImpl implements ExampleBobaService {
    private final ExampleBobaRepository exampleBobaRepository;

    @Override
    public List<ExampleBobaEntity> findAllExampleBoba() {
        return exampleBobaRepository.findAll();
    }
}
