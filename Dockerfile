FROM anapsix/alpine-java

RUN apk add --no-cache --update curl git

RUN mkdir -p /srv/personalwebsite

RUN curl -o /srv/personalwebsite/personalwebsite.jar -L https://github.com/femiagbabiaka/personalwebsite/releases/download/0.4.0/personalwebsite-standalone.jar

ADD docs /srv/personalwebsite/docs

EXPOSE 8080

CMD ["java", "-jar", "/srv/personalwebsite/personalwebsite.jar"]
