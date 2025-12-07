package iNas.mapper;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.model.ExampleBoba;
import org.mapstruct.Mapper;

@Mapper
public abstract class BobaMapper {

    public abstract ExampleBoba toExampleBoba(ExampleBobaEntity exampleBobaEntity);
    public abstract ExampleBobaEntity toExampleBobaEntity(ExampleBoba exampleBoba);
}