package iNas.bibaProj.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
@Schema(description = "Пример сущности")
public class Example {
    @Id
    @Schema(description = "ID примера", example = "1422 random UUID 2343")
    private UUID id;
    @Schema(description = "Имя примера", example = "Стремительный")
    private String name;
}
