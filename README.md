# Currency-checker  
Запуск  
`gradlew bootRun `  
<br/>
Открыть http://localhost:8080/  
<br/>
Смотреть гифки можно так:  
`http://localhost:8080/check-currency?currency=Аббревиатура валюты`  
<br/>
Например,  
`http://localhost:8080/check-currency?currency=AED` 
<br/>
или  
`http://localhost:8080/check-currency?currency=BHD`  
<br/>
Запуск тестов  
`gradlew test`  
<br/>
Генерирование докера  
`docker build --build-arg JAR_FILE=build/libs/\*.jar -t currency-mood .` 
<br/>
Запуск докера  
`docker run -p 8080:8080 currency-mood`  
<br/>
![Домашняя страница](https://github.com/ilpol/Currency-checker/blob/main/home_page.png)  
![Ответ с радостной гифкой](https://github.com/ilpol/Currency-checker/blob/main/happy.png)  
![Ответ с печальной гифкой](https://github.com/ilpol/Currency-checker/blob/main/unhappy.png)
  
