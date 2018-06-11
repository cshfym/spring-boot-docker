
h2. Build project:
gradle clean build
(Builds .war file in build/libs/<file.war>)

h2. Copy artifact to VM:
scp spring-boot-docker-1.0.0.war root@206.189.210.200:/usr/local/docker/spring-boot-docker
scp -i Quazar.pem \
 ../Development/Projects/spring-boot-docker/build/libs/spring-boot-docker-1.0.0.war \
 ubuntu@ec2-54-183-85-26.us-west-1.compute.amazonaws.com:\usr\local\pipeline

h2. Build Docker image:
docker build -t spring-boot-docker . --build-arg JAR_FILE=spring-boot-docker-1.0.0.war

h2. Execute Docker image (non-interactive):
docker run -d -p 8888:8080 spring-boot-docker

h2. Tag image (before push to DockerHub):
docker tag spring-boot-docker cshfym/demos:spring-boot-docker

h2. Push Docker image to DockerHub:

