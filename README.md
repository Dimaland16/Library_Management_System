# Library Management System

## Описание
**Library Management System** — это веб-приложение на базе Spring Boot, разработанное для управления библиотечным каталогом.
## Функциональные возможности
- Добавление, просмотр, редактирование и удаление книг.
- Поиск книг по названию.
- Фильтрация книг по категориям.

## Стек технологий
- **Spring Boot** — для быстрой и удобной разработки на Java.
- **Spring MVC** — для обработки HTTP-запросов и построения RESTful-сервисов.
- **Spring Data JPA** — для работы с базой данных MySQL.
- **Thymeleaf** — шаблонизатор для генерации HTML.
- **Maven** — для управления зависимостями и сборки проекта.
- **MySQL** — реляционная база данных для хранения информации о сущностях.

## Установка и запуск проекта
1. **Склонируйте репозиторий**:
    ```bash
    git clone https://github.com/Dimaland16/Library_Management_System.git
    ```

2. **Перейдите в директорию проекта**:
    ```bash
    cd Library_Management_System
    ```

3. **Настройте базу данных**:
   - Создайте базу данных MySQL, например `library_db`.
   - Укажите данные для подключения к базе данных в `application.properties`.

4. **Запустите приложение**:
    ```bash 
    mvn spring-boot:run
    ```

5. Откройте браузер и перейдите по адресу `http://localhost:8080/books`.

## Примеры работы
### Главная страница
![image](https://github.com/user-attachments/assets/ec5c0d43-22e4-41ea-ad8d-c0ab5c69d617)


### Список книг с функцией фильтрации
![image](https://github.com/user-attachments/assets/ef785193-a878-4b00-ab48-1b18401037d0)


### Список книг с функцией поиска по названию
![image](https://github.com/user-attachments/assets/be3144a8-5992-4117-be5c-042ad4e4f937)


### Страница добавления новой книги
![image](https://github.com/user-attachments/assets/19a38860-446c-49c0-b58a-8f99ff32d120)


### Страница редактирования книги
![image](https://github.com/user-attachments/assets/86fad03a-5c73-4514-b263-94020e4457c2)


### Страница с подробной информацией о книге
![image](https://github.com/user-attachments/assets/b1176066-0d99-463b-9fda-92381959efe7)


