FROM openjdk:17
EXPOSE 8585
ADD build/libs/EmployeeDetailsManagement-0.0.1-SNAPSHOT.jar EmployeeDetailsManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","/EmployeeDetailsManagement-0.0.1-SNAPSHOT.jar" ]

