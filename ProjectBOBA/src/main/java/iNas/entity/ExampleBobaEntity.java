package iNas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Table(name = "example")
public class ExampleBobaEntity {
    @Id
    private UUID id;
    private String name;
}
