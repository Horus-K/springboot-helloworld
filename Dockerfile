FROM registry.cn-hangzhou.aliyuncs.com/xqbl-share/openjkd:ubunut1804-openjdk11.0.7-v1

COPY . /data/springboot-helloworld
WORKDIR /data/springboot-helloworld

# RUN ["mvn", "clean", "install"]

RUN mv target/helloworld-0.0.1-SNAPSHOT.jar /opt/myapp.jar
