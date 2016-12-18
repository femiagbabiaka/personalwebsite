FROM anapsix/alpine-java

RUN apk add --no-cache --update curl git && rm /var/cache/apk/*

RUN curl -o /srv/personalwebsite.jar -L https://github.com/femiagbabiaka/personalwebsite/releases/download/0.1.1/personalwebsite-standalone.jar

EXPOSE 8080

CMD ["java", "-jar", "/srv/personalwebsite.jar"]
