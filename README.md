# Spring Boot PostgreSQL Base Project

Damián Campana 
October 4, 2022

Technologies Used
- Spring Boot 2.4.1
- Spring Data JPA
- Lombok
- PostgreSQL

How to Run this application. Please follow this steps. 

1
./gradlew clean build

2
sudo docker-compose build

3
sudo docker-compose up

4 
You have to add token for the request, you can get it from this request
curl --location --request POST 'http://localhost:8080/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
"username": "peter",
"password": "peter"
}'

5
I Add a postman collections with examples

6
To filter courses by student name
curl --location --request GET 'http://localhost:8080/courses/studentName?name=student2' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRlciIsImV4cCI6MTY2NTAyMDUxNywiaWF0IjoxNjY0OTg0NTE3fQ.9tFnrp2IbS-5xLS_KrIYmKm-Cz9A8MijpJ9BS_1PaoU' \

To filter courses without students
curl --location --request GET 'http://localhost:8080/courses/withoutStudents' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRlciIsImV4cCI6MTY2NTAyMDUxNywiaWF0IjoxNjY0OTg0NTE3fQ.9tFnrp2IbS-5xLS_KrIYmKm-Cz9A8MijpJ9BS_1PaoU' \

7
To filter students by course name
curl --location --request GET 'http://localhost:8080/students/courseName?name=course1' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRlciIsImV4cCI6MTY2NTAyMDUxNywiaWF0IjoxNjY0OTg0NTE3fQ.9tFnrp2IbS-5xLS_KrIYmKm-Cz9A8MijpJ9BS_1PaoU' \

to filter students without courses
curl --location --request GET 'http://localhost:8080/students/withoutCourse' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRlciIsImV4cCI6MTY2NTAyMDUxNywiaWF0IjoxNjY0OTg0NTE3fQ.9tFnrp2IbS-5xLS_KrIYmKm-Cz9A8MijpJ9BS_1PaoU' \

8
To  enroll student to a courses (POST action)
curl --location --request POST 'http://localhost:8080/enrollment/add' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXRlciIsImV4cCI6MTY2NTAyMDUxNywiaWF0IjoxNjY0OTg0NTE3fQ.9tFnrp2IbS-5xLS_KrIYmKm-Cz9A8MijpJ9BS_1PaoU' \
--header 'Content-Type: application/json' \
--data-raw '{
"studentId": 1,
"courseId": 6
}'
