FROM java:8
WORKDIR /app

ADD ./target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

CMD java -jar api-0.0.1-SNAPSHOT.jar