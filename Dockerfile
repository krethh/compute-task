FROM arm64v8/openjdk:7
WORKDIR /
ADD target/compute-task-1.0-SNAPSHOT.jar compute-task.jar
CMD java -jar compute-task.jar