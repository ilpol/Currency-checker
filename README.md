# Currency-checker  
Запуск  
`gradlew bootRun `  
Открыть http://localhost:8080/  
Смотреть гифки можно так: 
`http://localhost:8080/check-currency?currency=Аббревиатура валюты`  
Например,  
`http://localhost:8080/check-currency?currency=AED`  
или  
`http://localhost:8080/check-currency?currency=BHD`  
Запуск тестов  
`gradlew test`  
Генерирование докера  
`docker build --build-arg JAR_FILE=build/libs/\*.jar -t currency-mood .`  
Запуск докера  
`docker run -p 8080:8080 currency-mood`  
