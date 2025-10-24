package iNas.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI configOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Biba API")
                        .version("1.0")
                        .description("здесь должно быть описание API..")
                        .contact(new Contact()
                                .name("Контактное лицо")
                                .email("myEmail@com")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("iNas external Docs")
                        .url("адрес внешней доки")
                );
    }
}
