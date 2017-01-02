FROM java:8

WORKDIR /opt/gallery
RUN mkdir photos

VOLUME /tmp
COPY ./photos/*.jpg /opt/gallery/photos/

COPY build/libs/*.jar /opt/gallery/app.jar
RUN sh -c 'touch /opt/gallery/app.jar'

ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java -jar /opt/gallery/app.jar" ]
EXPOSE 8081
