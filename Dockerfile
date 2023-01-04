FROM ubuntu:latest
EXPOSE 8089
ADD target/Ccbp.jar Ccbp.jar 
ENTRYPOINT ["java","-jar","Ccbp.jar"]