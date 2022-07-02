# Calculating_Next_Number Application Using Spring Boot, Spring Security, JWT, JPA and MySql

## Requirements

1. Java >= java 11

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. lombok

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/shanthan-reddy-annedi/Calculating_Next_Number.git
```

**3. Change mysql username and password as per your Mysql installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Running the application in the IDE**

+ after changing both the username and password as per your mysql installation
+ we can run it from NeatBeans or intellij IDEA.

**5. Build and running the app using maven**

+ open the terminal in the project folder and run the following commands.

```bash
mvn package
java -jar target/Calculating_next_number-0.0.1-SNAPSHOT.jar
```

+ We can use below command to run the program. if there already exist a executable jar.

```bash
mvn spring-boot:run
```

The app will start running at http://localhost:8080/**.
