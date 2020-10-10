FROM arm32v7/openjdk:8
WORKDIR /
ADD target/compute-task-1.0-SNAPSHOT.jar compute-task.jar
RUN chmod 777 compute-task.jar
CMD java -jar compute-task.jar
