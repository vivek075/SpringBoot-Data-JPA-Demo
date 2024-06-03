**SpringBoot Data JPA Demo**

This Spring Boot application demonstrates transactionality with Spring Data JPA and Thymeleaf. 
The `transactionalMethodExample` in PersonService shows how a transaction can be rolled back if an exception is thrown. 
You can test this by navigating to `/transaction` and observing that no new users are added due to the intentional exception, demonstrating transaction rollback behavior.

This application will include the following features:

A simple entity Person.

A repository interface for CRUD operations.

A service class with transactional methods.

A Thymeleaf-based web interface to create and list users.

Demonstration of transactionality.