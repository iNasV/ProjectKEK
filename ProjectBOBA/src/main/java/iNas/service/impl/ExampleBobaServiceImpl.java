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
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ExampleBobaServiceImpl implements ExampleBobaService {
    private final ExampleBobaRepository exampleBobaRepository;
    private final BobaMapper bobaMapper;

    @Override
    public List<ExampleBoba> findAllExampleBoba() {
        return StreamSupport.stream(exampleBobaRepository.findAll().spliterator(), false)
                        .map(bobaMapper::toExampleBoba)
                        .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ExampleBoba saveExampleBoba(ExampleBoba boba) {
        ExampleBobaEntity entity = bobaMapper.toExampleBobaEntity(boba);
        exampleBobaRepository.insert(entity.getId(), entity.getName());
        return boba;
    }

}