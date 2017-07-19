FROM java:8-jre
MAINTAINER Mradul Pandey <pandeymradul@gmail.com>

ADD ./docker-user.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/docker-user.jar"]

EXPOSE 8080