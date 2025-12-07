package iNas.service;

import iNas.generated.model.ExampleBoba;

import java.util.List;

public interface ExampleBobaService {
    List<ExampleBoba> findAllExampleBoba();
    ExampleBoba saveExampleBoba(ExampleBoba boba);
}
