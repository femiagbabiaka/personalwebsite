FROM anapsix/alpine-java

ADD target/personalwebsite-standalone.jar /srv/personalwebsite.jar

EXPOSE 8080

CMD ["java", "-jar", "/srv/personalwebsite.jar"]
