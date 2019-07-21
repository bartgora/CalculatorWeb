FROM openjdk:8-jdk-alpine
VOLUME /temp
ADD target/CalculatorWeb-1.0-SNAPSHOT.war CalculatorWeb.war
EXPOSE 8080
CMD java -jar CalculatorWeb.war