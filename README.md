# «Основы Spring»
## Задача
Реализуйте веб-сервис, который бы принимал на GET-запросы вида
http://localhost:8080/greeting, а в ответ отображал страницы вида “Hello World!”
Также потребуется внедрить параметр name, при передаче которого наше
отображение бы изменилось на http://localhost:8080/greeting?name=Vasya с
отображением “Hello Vasya!
## Необходимые зависимости для решения задачи
```xml
<dependency>
 <groupId> org.springframework.boot </groupId>
 <artifactId> spring-boot-starter-web </artifactId>
</dependency>
<dependency>
 <groupId> org.springframework.boot </groupId>
 <artifactId> spring-boot-starter-thymeleaf </artifactId>
</dependency>
```
Spring-boot-starter-web - стартер, который содержит основные зависимости для
реализации веб-приложения.
Spring-boot-starter-thymeleaf - стартер, который содержит основные
зависимости для корректной работы шаблонизатора Thymeleaf
## Создание контроллера
При подходе Spring к построению веб-сайтов HTTP-запросы обрабатываются
контроллером. Вы можете определить эти запросы аннотацией @Controller.
В примере ниже GreetingController обрабатывает GET запросы для /greeting,
возвращая название View. В данном случае это "greeting". View отвечает за
рендеринг HTML-содержимого.
## Реализация контроллера
Аннотация @RequestMapping гарантирует, что HTTP-запросы к /greeting приведут к 
выполнению метода greeting().
```java
@Controller
@RequestMapping ("/v1")
public class MainController {
  @GetMapping("/greeting" )
  public String greeting(@RequestParam (required = false, defaultValue = "World") String name ,
Model model) {
     model.addAttribute( "name", name);
     return "greeting
   }
}
 ```
В приведенном примере нет GET, PUT и POST, потому что @RequestMapping
соответствует всем HTTP-операциям по умолчанию.
@RequestMapping(method=GET) уточняет это соответствие. 
## Реализация представления
@RequestParam связывает значение строкового параметра name запроса с name
параметром метода greeting(). Этот параметр не required: если он отсутствует в запросе, то
будет использовано defaultValue значение "World". Значение параметра name добавлено в
объект Model, что делает его доступным в шаблоне представления.
Реализация тела метода основывается на view technology (в данном случае Thymeleaf), который
выполняет рендеринг на стороне сервера в HTML.
Thymeleaf парсит шаблон greeting.html и вычисляет выражение th:text для рендеринга значения
параметра ${name}, который был установлен контроллером.
```html
src/main/resources/templates/greeting.html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
 <title>Getting Started: Serving Web Content</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
 <p th:text="'Hello, ' + ${name} + '!'" />
 </body>
</html>
```
## View technology
Шаблон проектирования Model-View-Controller (MVC) применяется в качестве способа
разделения задач в приложении. Логика приложения или контроллер отделены от
технологии, которая используется для отображения пользователю информации. Модель
осуществляет взаимодействие между контроллером и слоем представления
Для отображения представления может использоваться одна или больше технологий в
слое представления. Spring веб-приложения поддерживают различные варианты
представлений (чаще в виде шаблонов). Эти технологии описаны, как templates, потому
что они предоставляют язык разметки с доступом к атрибутам модели в процессе 
рендеринга на стороне сервера.
## Создание приложения исполняемым
Аннотация @EnableWebMvc используется для включения в приложении Spring MVC и работает
путем импорта конфигурации Spring MVC из WebMvcConfigurationSupport.
Точка входа в приложение Spring Boot – класс, который содержит аннотацию
@SpringBootApplication и метод main.
```java
@EnableWebMvc
@SpringBootApplication
public class Main {
   public static void main(String[] args) {
   SpringApplication. run(Main.class); 
   }
}
```
## Домашнее задание
Цель домашнего задания — доработать веб-сервис,
реализованный на вебинаре. Необходимо добавить
дату входа на страницу http://localhost:8080/greeting

`Hello, World!`  

`Дата входа на страницу:2022-12-19`
