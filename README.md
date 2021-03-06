# Questionnaire
Веб сервис "Онлайн тестирование"

Сборка проекта
------
Для сборки проекта в корневом каталоге репозитория в командной строке запустить команду:

mvn clean install

После сборки в каталоге `\target\` появится файл `questionnaire-0.0.1.jar`

Запуск приложения
------
Файл `questionnaire-0.0.1.jar`, сформированный на этапе сборки, разместить в отдельной папке (например questionnaire)
и запустить приложение в командной строке следующим образом:

java -jar questionnaire-0.0.1.jar

Настройки
------
Приложение использует файл конфигурации `resources/application.properties`. 
В файле указаны настройки подключения к базе данных.
В файле ../resources/db/migration/V1__InitDB.sql расположены DDL скрипты для миграции базы данных c использованием FlyWay

Перед запуском 
-------
Создать базу данных на сервере и установить параметр spring.flyway.enabled=true в файле конфигурации `resources/application.properties` 

После запуска приложения и инициализации базы данных установить параметр spring.flyway.enabled=false

Документация REST сервиса
------
http://localhost:8080/swagger-ui.html

Используемые технологии
-------
* Java 8
* Spring Boot 2.2.4
* Postgresql 12
* flywaydb
* Swagger



