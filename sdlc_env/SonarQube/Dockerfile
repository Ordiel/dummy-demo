# Jenkins Docker Image 
## + Maven, JDK 8
#### Dockerfile that creates a jenkins image
#### pre-loaded and pre-configured with maven
#### running over JDK-8.
# 
### HOWTO
#### Build this image; Replace "X.X.X" by the desired version

#####     `docker build -t ordiel/jenkins:X.X.X .`

    FROM jenkins/jenkins:lts
    MAINTAINER Ordiel "ordiel1910@gmail.com"

### Build phase
    USER root
    RUN apt update
    RUN apt upgrade -y
    RUN apt install maven -y
    RUN echo "M2_HOME=/usr/share/maven/bin/mvn" >> /etc/environment

#    RUN mkdir /opt/maven
#    ADD db /drae/db
#    ADD bin /drae/bin
#    RUN chmod +x /drae/bin/*
#    EXPOSE 3306

### INIT Phase
    ENTRYPOINT  ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]