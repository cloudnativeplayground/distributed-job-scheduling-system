@echo off
rem Create base directories
mkdir distributed-job-scheduling-system
cd distributed-job-scheduling-system

rem Create folders
mkdir bin
mkdir config
mkdir docs
mkdir src
mkdir src\main
mkdir src\main\java
mkdir src\main\java\com
mkdir src\main\java\com\cloudnativeplayground
mkdir src\main\java\com\cloudnativeplayground\scheduler
mkdir src\main\java\com\cloudnativeplayground\scheduler\config
mkdir src\main\java\com\cloudnativeplayground\scheduler\controller
mkdir src\main\java\com\cloudnativeplayground\scheduler\model
mkdir src\main\java\com\cloudnativeplayground\scheduler\repository
mkdir src\main\java\com\cloudnativeplayground\scheduler\service
mkdir src\main\java\com\cloudnativeplayground\scheduler\util
mkdir src\main\resources
mkdir target

rem Create sample files in the folders
echo "application.yml" > src\main\resources\application.yml
echo "logback.xml" > src\main\resources\logback.xml
echo "pom.xml" > pom.xml
echo ".gitignore" > .gitignore

rem Creating a sample class file (you can expand with other files later)
echo "package com.cloudnativeplayground.scheduler;" > src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "import org.springframework.boot.SpringApplication;" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "import org.springframework.boot.autoconfigure.SpringBootApplication;" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "@SpringBootApplication" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "public class MainApplication {" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "   public static void main(String[] args) {" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "      SpringApplication.run(MainApplication.class, args);" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "   }" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java
echo "}" >> src\main\java\com\cloudnativeplayground\scheduler\MainApplication.java

rem Notify the user
echo "Project structure created successfully."
pause
