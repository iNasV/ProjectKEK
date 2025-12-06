package iNas.bibaProj.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder
@Schema(description = "Пример сущности")
@NoArgsConstructor
@AllArgsConstructor
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "ID примера", example = "1422 ... random UUID ... 2343")
    private UUID id;
    @Schema(description = "Имя примера", example = "Стремительный")
    private String name;
}
