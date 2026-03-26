FROM maven:3.8.5-openjdk-17-slim

ADD . /usr/src/ppt-game
WORKDIR /usr/src/ppt-game
EXPOSE 8081
ENTRYPOINT ["mvn", "clean", "install", "spring-boot:run"]