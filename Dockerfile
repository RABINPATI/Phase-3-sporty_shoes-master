From openjdk:8
Expose 8090
Add target/sporty_shoes-0.0.1-SNAPSHOT.jar sporty_shoes-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/sporty_shoes-0.0.1-SNAPSHOT.jar"]