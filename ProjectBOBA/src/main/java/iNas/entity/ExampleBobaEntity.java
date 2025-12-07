package iNas.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Builder
@Table(name = "example")
public class ExampleBobaEntity {

    @Id
    private UUID id;
    private String name;
}
