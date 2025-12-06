package iNas.bibaProj.service;

import iNas.bibaProj.entity.Example;

import java.util.List;

public interface ExampleService {
    List<Example> findAllExample();
    Example saveExample(String description);
}
