# Jenkins Docker Image

##### Dockerfile that creates a jenkins image
##### pre-loaded and pre-configured with maven
##### running over JDK-8.

##### This file is created to be also kind of readable
##### as a Markdown document

## HOWTO
### Build this image; Replace "X.X.X" by the desired version

#       `docker build -t ordiel/jenkins:X.X.X .`

## Dockerfile

### Image Definition & Info
    FROM jenkins/jenkins:lts
    LABEL maintainer="ordiel1910@gmail.com"

### Build phase
    USER root
    RUN apt update
    RUN apt upgrade -y
    RUN apt install maven -y
    RUN echo "M2_HOME=/usr/share/maven/bin/mvn" >> /etc/environment
    COPY layout /tmp/jenkins_layout
    COPY sh_exec/brand-jenkins.sh /usr/local/bin/
    RUN chmod +x /usr/local/bin/brand-jenkins.sh
    RUN rm /usr/local/bin/jenkins.sh
    COPY sh_exec/jenkins.sh /usr/local/bin/
    RUN chmod +x /usr/local/bin/jenkins.sh

### INIT Phase
    ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]