package com.green.boardver4.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Board Ver4"
                , description = "CRUD Board Study"
                , version = "v0.0.3"
        )
)
public class SwaggerConfiguration {

}
