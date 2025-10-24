package iNas.bibaProj.controller;

import iNas.bibaProj.entity.Example;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Tag(name="Example controller", description = "Контроллер для примера")
public interface ExampleController {

    @GetMapping("/")
    @Operation(summary = "Метод для получения всех example")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успех")
    })
    ResponseEntity<List<Example>> getAllExample();
}
