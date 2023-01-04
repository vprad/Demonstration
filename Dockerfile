FROM openjdk:8
EXPOSE 8089
ADD target/Ccbp.jar Ccbp.jar 
ENTRYPOINT ["java","-jar","Ccbp.jar"]