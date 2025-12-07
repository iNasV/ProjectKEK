package iNas.service.impl;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.model.ExampleBoba;
import iNas.mapper.BobaMapper;
import iNas.repository.ExampleBobaRepository;
import iNas.service.ExampleBobaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExampleBobaServiceImpl implements ExampleBobaService {
    private final ExampleBobaRepository exampleBobaRepository;
    private final BobaMapper bobaMapper;

    @Override
    public List<ExampleBoba> findAllExampleBoba() {
        return exampleBobaRepository.findAllAsList().stream()
                .map(bobaMapper::toExampleBoba)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ExampleBoba saveExampleBoba(ExampleBoba boba) {
        ExampleBobaEntity entity = bobaMapper.toExampleBobaEntity(boba);
        ExampleBobaEntity saved = exampleBobaRepository.save(entity);
        return bobaMapper.toExampleBoba(saved);
    }

}