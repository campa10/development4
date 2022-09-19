# Spring Boot PostgreSQL Base Project

Hernan Bogantes 
September 18, 2022

Technologies Used
- Spring Boot 2.4.1
- Spring Data JPA
- Lombok
- PostgreSQL

How to Run this application
I created this using Linux OS
Please follow this steps 

1
./gradlew clean build

2
sudo docker-compose build

3
sudo docker-compose up

4
To fetch all courses
http://localhost:8080/courses/getAll

5
To  add new courses (POST action)
PLease do first a getAll to find out the next inmediate ID Sequence number so you can get a successfull submission
curl --location --request POST 'http://localhost:8080/courses/add' --header 'Content-Type: application/json' --data-raw '{ "id":"116", "coursename": "course5" }'

6
To add new Students you can run this (POST)
curl --location --request POST 'http://localhost:8080/students/add' --header 'Content-Type: application/json' --data-raw '{"id": 120,"studentname": "student7","courseid": 3 }'
To continue adding you need to check the latest id and use the immediate next value. The autoincrement was not set it up.



