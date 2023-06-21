# FormValidationAssignment
Implementing login and signup with spring securiy

#Installing the spring boot project
 1. First initialize the project in spring.io ,add required dependency such as Spring Web,Spring Security,Spring Data JPA & H2 Database
 2. Open the project in ide and let it configure itself by pressing ctrl+shift+o and run to see if everything is working
 3. then make proper models,controllers,services,repositories and then integrate them 
 4. using spring security we are implementing security into the project as validation and authorization of user.
 5. Additional dependency  used for the token validation is 
    <dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
