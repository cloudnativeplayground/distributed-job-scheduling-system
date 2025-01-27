

Distributed Job Scheduling System
=================================

Overview
--------
The Distributed Job Scheduling System is a Spring Boot-based application designed to manage and execute distributed jobs and tasks efficiently. The system leverages Spring Batch for batch job processing, RabbitMQ for message-based task queuing, and a MySQL database for persistent data storage.

Features
--------
- Job Management: Create, update, and manage jobs with priority and enablement status.
- Task Management: Define tasks associated with jobs, track their completion status, and manage retries.
- Execution Tracking: Monitor job executions with retry counts, status tracking, and detailed logging.
- Retry Mechanism: Configurable retry logic for failed tasks with customizable delays.
- RabbitMQ Integration: Message-based queuing system for asynchronous task execution.
- MySQL Integration: Persistent storage of jobs, tasks, and executions.
- Logging: Configurable logging with support for detailed and error logs.

Project Structure
-----------------
```
src/
├── main/
│   ├── java/com/cloudnativeplayground/scheduler/
│   │   ├── config/          - Configuration classes (Batch, RabbitMQ, DataSource)
│   │   ├── controller/      - REST controllers for Jobs, Tasks, and Executions
│   │   ├── model/           - Domain models for Job, Task, JobExecution
│   │   ├── repository/      - JPA repositories for database access
│   │   ├── service/         - Business logic for job and task management
│   │   └── util/            - Utility classes for logging, retries, and date handling
│   └── resources/
│       ├── application.yml  - Application configuration
│       └── logback.xml      - Logging configuration
```

API Endpoints
-------------
### Job API (/api/jobs)
- POST /api/jobs: Create or update a job.
- GET /api/jobs/{id}: Get a job by its ID.
- GET /api/jobs/name/{name}: Get a job by its name.
- GET /api/jobs/enabled: Get all enabled jobs.
- GET /api/jobs/priority/{priority}: Get jobs sorted by priority.
- DELETE /api/jobs/{id}: Delete a job by its ID.

### Job Execution API (/api/jobexecutions)
- POST /api/jobexecutions: Create or update a job execution.
- GET /api/jobexecutions/job/{jobId}: Get executions by job ID.
- GET /api/jobexecutions/job/{jobId}/latest: Get the latest execution of a job.
- GET /api/jobexecutions/status/{status}: Get executions by status.
- GET /api/jobexecutions/retry/{retryCount}: Get executions with a retry count greater than a value.
- DELETE /api/jobexecutions/{id}: Delete a job execution by its ID.

### Task API (/api/tasks)
- POST /api/tasks: Create or update a task.
- GET /api/tasks/job/{jobId}: Get tasks by job ID.
- GET /api/tasks/job/{jobId}/completed/{completed}: Get tasks by job ID and completion status.
- GET /api/tasks/name/{taskName}/job/{jobId}: Get tasks by name and job ID.
- DELETE /api/tasks/{id}: Delete a task by its ID.

Configuration
-------------
### Database
The application uses MySQL as its persistent storage. Configure the database connection in `application.yml`:
```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/job_scheduler_db?useSSL=false&serverTimezone=UTC
    username: root
    password: password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### RabbitMQ
Configure RabbitMQ properties in `application.yml`:
```
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
    virtual-host: /
```

### Logging
Logging is configured in `logback.xml` with console and file appenders:
- Logs are saved to `logs/application.log`.
- Adjust logging levels in `logback.xml`.

Prerequisites
-------------
- Java 11 or higher
- Maven 3.6+ or Gradle 6+
- MySQL database
- RabbitMQ server

Build and Run
-------------
### Using Maven
```
mvn clean install
mvn spring-boot:run
```

### Using Gradle
```
gradle clean build
gradle bootRun
```

License
-------
This project is licensed under the GNU 3 Public License.

Maintainer
----------
Aditya Pratap Bhuyan  
Senior Architect, Developer, Instructor, and Author  
Profile: [https://linkedin.com/in/adityabhuyan] 

--- 

