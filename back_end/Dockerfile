FROM openjdk:23-jdk-bookworm
WORKDIR /app
COPY . .
RUN sed -i 's/deb.debian.org/mirrors.aliyun.com/g' /etc/apt/sources.list.d/debian.sources
RUN apt update
RUN apt install -y maven
RUN mkdir -p /root/.m2/
RUN cp settings.xml ~/.m2/settings.xml
RUN mvn clean install
ENTRYPOINT [ "bash","-c","/app/run.sh" ]
