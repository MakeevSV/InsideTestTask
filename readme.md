Для решения тестового задания были использованы:
-Spring Boot
-Spring Security
-Spring Data JPA
Дополнительно использовались:
-Model Mapper
-JWT

Ввиду отсутствия сложных запросов к БД выбор пал на Spring Data JPA. СУБД PostgreSQL.



Endpoints:
POST "*/api/v1/auth"
Ожидает:
{
name: "имя отправителя"
password: "пароль"
}
вернет 
{
token: "токен"
}

POST "*/api/v1/message"
Ожидает:
Header "Authorization : Bearer_TOKEN"
Body "{
name:"имя отправителя"
message: "текст сообщения"
}"
Если в поле message содержится "history N" - то вернется N последних сообщений

