# Hotmart Challenge

## Important
The project was built to use Spring's microservice architecture https://spring.io/microservices, the challenge was made in the hm-products project all the required logic of the challenge is in it.


## Version JDK and Data base

- Java: 11
- Mysql: latest

## How execute the project in Linux

### Prerequisites

1. Clone the project:
  ```https://github.com/andrericardoalves/hm-marketplace.git```
2. Install Mysql:
   ```Install mysql version 8```
 
3. Create the database:
   ```Create the database hmproductsdb ```
   
4. Scripts load data:
   ```the bank load scripts and relational model are in the data folder ```
  
### Running the unit tests
1.Enter the project directory and run:
   ```mvn test```

### Running the project
1. Enter the project directory and run:
   ```mvn spring-boot:run```
   
## Populating the News table
With the project running make the following request:
   ```[GET] http://localhost:8080/hmproducts/news/obtainNewsByOrderByRanking```

### Business rule for daily update
We have a registered schedule that runs the code every 6 hours starting at 12 PM.

The call to the external api is made by passing the following parameters:

* .path ("/ top-headlines") *
* .queryParam ("category", category.getName ()) *
  * .queryParam ("apiKey", NEWS_API_APIKEY) *
  * .queryParam ("country", "us") *

** Current day news is filtered and validated in the business rule:
Z = Quantity of news from the product category on the current day

#### Comments


## Implementation decisions

1. A ** product ** belongs to several ** categories **.
2. The buyer and seller fields were taken from the business model.


## Data Base

![database](files/hmproducts_ER_Diagram.png)

## Considerations

1. The Resp Api documentation was made only for product crud. To access it, just run the project and access the link <localhost:8080/swagger-ui.html>