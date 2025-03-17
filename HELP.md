# SoftSolutions Technologies LLC 
 Official website for SoftSolutions Technologies LLC

# Spring Boot Application  
This is a Spring Boot web application for **SoftSolutions Technologies LLC**, providing various IT services.  

## **Project Setup & Run Guide**  

### **1. Prerequisites**  
Ensure you have the following installed:  
- **Java 17+**  
- **Maven 3+**  
- **Spring Boot**  
- **H2 Database** (Embedded, no external setup needed)  
- **Git** (Optional)  

---

### **2. Clone the Repository**  
```sh
git clone https://github.com/your-repo/softsolutions.git
cd softsolutions
```

---

### **3. Configure Database (H2 - Embedded)**  
The application uses an in-memory **H2 database**, configured in `src/main/resources/application.properties`:  

```properties
# Application Name
spring.application.name=SoftSolutionsTechnologiesLLC

# DataSource Configuration (H2 Database)
spring.datasource.url=jdbc:h2:file:./data/softsolutionsdb 
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=1234
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Hibernate Settings
spring.jpa.hibernate.ddl-auto=update  
spring.jpa.show-sql=true  

# DevTools & Live Reload
spring.devtools.livereload.enabled=true
spring.devtools.restart.enabled=true

# Security Debugging
logging.level.org.springframework.security=DEBUG

# Enable H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

To access the **H2 console**:  
- Run the app and go to `http://localhost:8080/h2-console`  
- Use JDBC URL: `jdbc:h2:file:./data/softsolutionsdb`  
- Username: `sa`, Password: `1234`  

---

### **4. Build & Run the Application**  

#### **Option 1: Using Maven (Recommended)**  
```sh
mvn clean install
mvn spring-boot:run
```

#### **Option 2: Using Java (After Build)**  
```sh
java -jar target/softsolutions-0.0.1-SNAPSHOT.jar
```

---

### **5. Access the Application**  

Once running, open in a browser:  
- **Home Page:** [http://localhost:8080](http://localhost:8080)  
- **H2 Database Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
- **Services Pages:**  
  - IT Services: [http://localhost:8080/it](http://localhost:8080/it)  
  - Cybersecurity: [http://localhost:8080/cybersecurity](http://localhost:8080/cybersecurity)  
  - Software Development: [http://localhost:8080/software](http://localhost:8080/software)  
  - AI & Business Intelligence: [http://localhost:8080/ai](http://localhost:8080/ai)  

---

### **6. Security & Authentication**  
By default, some pages are **publicly accessible**. You can modify access in `SecurityConfig.java` if needed.  

To **disable security** (for development only), modify `SecurityConfig.java`:  
```java
http
    .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
    .csrf(csrf -> csrf.disable());
```

---

### **7. Stopping the Application**  
To stop a running instance, press `CTRL + C` in the terminal.  

If running in the background:  
```sh
kill $(lsof -t -i:8080)
```

---

### **8. Deployment (Production Setup)**  
For a production build:  
```sh
mvn clean package
java -jar target/softsolutions-0.0.1-SNAPSHOT.jar
```

For deployment options, consider **Docker, AWS, or DigitalOcean**.  

---

### **Troubleshooting**  

#### **Port 8080 Already in Use?**  
Change the port in `application.properties`:  
```properties
server.port=9090
```
Run with:  
```sh
mvn spring-boot:run
```
Now, access at [http://localhost:9090](http://localhost:9090).  

#### **Database Issues?**  
If the H2 database is not working:  
- Check `http://localhost:8080/h2-console`  
- Verify JDBC URL: `jdbc:h2:file:./data/softsolutionsdb`  
- Make sure **H2 is enabled** in `application.properties`  

---

### **Author**  
SoftSolutions Technologies LLC 🚀  

For questions or support, contact **support@softsolutions.com**  
```