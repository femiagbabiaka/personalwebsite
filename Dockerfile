FROM anapsix/alpine-java

RUN apk add --no-cache --update curl git

RUN mkdir -p /srv/personalwebsite

ADD ./target/personalwebsite-standalone.jar /srv/personalwebsite/personalwebsite.jar 

ADD docs /srv/personalwebsite/docs

EXPOSE 8080

CMD ["java", "-jar", "/srv/personalwebsite/personalwebsite.jar"]
