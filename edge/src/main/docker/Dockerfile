FROM java:8

ADD edge.jar app.jar
RUN sh -c 'touch /app.jar' && sleep 1

ENV JAVA_OPTS -server -XX:+PrintGCDateStamps -verbose:gc -XX:+PrintGCDetails -Xloggc:"/var/log/java/gc/" -Dsun.net.inetaddr.ttl=90 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath="/var/log/java/heap/"`date`.hprof

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

EXPOSE 8080