package questionnaire;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
@EnableSwagger2
public class QuestionnaireApplication
{
	public static void main(String[] args)
	{
		Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/questionnaire",
				"postgres",
				"12345").load();

		flyway.migrate();

		SpringApplication.run(QuestionnaireApplication.class, args);
	}

	@Bean
	public Docket swaggerDoc()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("questionnaire"))
				.build();
	}
}
