FROM openjdk:17

WORKDIR /app

COPY build/libs/queue-worker-mail.jar /app/queue-worker-mail.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "queue-worker-mail.jar"]

# docker build -t [username]/[image_name]:[version] .
# docker push [username]/[image_name]:[version]