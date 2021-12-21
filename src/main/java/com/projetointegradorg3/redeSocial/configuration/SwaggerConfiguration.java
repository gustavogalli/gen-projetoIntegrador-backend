package com.projetointegradorg3.redeSocial.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Projeto Integrador G3").description("Projeto Integrador G3 - Generation Brasil")
                        .version("v0.0.1")
                        .license(new License().name("Generation Brasil").url("https://brazil.generation.org/\r\n"))
                                .contact(new Contact().name("Grupo G3").url("---")
                                .email("ProjetoIntegradorG3@gmail.com")))
                .externalDocs(new ExternalDocumentation().description("GitHub")
                		.url("---"));
 
    }
}
