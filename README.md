*Запуск PostgreSQL в Docker*
- ```docker run --name pg-books -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=books -p 5432:5432 -d postgres:16```


1. GET localhost:8080/api/books
![img.png](img/img.png)
2. GET localhost:8080/api/books/2
![img.png](img/img2.png)
3. POST localhost:8080/api/books
![img.png](img/img3.png)
4. PUT localhost:8080/api/books

Было:
![img.png](img/img5.png)
Стало:
![img.png](img/img6.png)
5. DELETE localhost:8080/api/books/3
![img.png](img/img7.png)
![img.png](img/img8.png)
![img.png](img/img9.png)
