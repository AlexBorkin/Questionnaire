package questionnaire;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
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
}
