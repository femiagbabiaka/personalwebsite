FROM dockerfile/java

RUN sudo apt-get update

ADD target/personalwebsite-standalone.jar /srv/personalwebsite.jar

EXPOSE 8080

CMD ["java", "-jar", "/srv/personalwebsite.jar"]
