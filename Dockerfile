FROM openjdk:8
EXPOSE 8086
COPY target/springboot-mysql-2022-*.jar springboot-mysql.jar
CMD ["java", "-jar", "springboot-mysql.jar"]