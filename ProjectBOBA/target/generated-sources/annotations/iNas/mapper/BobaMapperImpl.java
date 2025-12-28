package iNas.mapper;

import iNas.entity.ExampleBobaEntity;
import iNas.generated.model.ExampleBoba;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-28T03:55:05+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class BobaMapperImpl extends BobaMapper {

    @Override
    public ExampleBoba toExampleBoba(ExampleBobaEntity exampleBobaEntity) {
        if ( exampleBobaEntity == null ) {
            return null;
        }

        ExampleBoba exampleBoba = new ExampleBoba();

        exampleBoba.setId( exampleBobaEntity.getId() );
        exampleBoba.setName( exampleBobaEntity.getName() );

        return exampleBoba;
    }

    @Override
    public ExampleBobaEntity toExampleBobaEntity(ExampleBoba exampleBoba) {
        if ( exampleBoba == null ) {
            return null;
        }

        ExampleBobaEntity.ExampleBobaEntityBuilder exampleBobaEntity = ExampleBobaEntity.builder();

        exampleBobaEntity.id( exampleBoba.getId() );
        exampleBobaEntity.name( exampleBoba.getName() );

        return exampleBobaEntity.build();
    }
}
