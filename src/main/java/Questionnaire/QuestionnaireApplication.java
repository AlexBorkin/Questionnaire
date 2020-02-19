package questionnaire;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuestionnaireApplication
{
	public static void main(String[] args)
	{
		/*Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/quest",
				"postgres",
				"12345").load();

		flyway.migrate();
		 */

		SpringApplication.run(QuestionnaireApplication.class, args);




	}

}
