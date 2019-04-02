FROM ubuntu:14.04

# For install steps
USER root

RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get dist-upgrade -y
RUN apt-get install -y unzip
RUN apt-get install -y software-properties-common
+

RUN add-apt-repository --yes ppa:openjdk-r/ppa \
    && apt-get update \
    && echo openjdk-11-jdk shared/accepted-oracle-license-v1-2 select true | debconf-set-selections

RUN apt-get update && \
    apt-get install -y  openjdk-11-jdk && \
    apt-get install -y ant && \
    apt-get clean

RUN apt-get install wget

RUN sudo update-ca-certificates && \
    wget -q https://services.gradle.org/distributions/gradle-4.10.2-bin.zip && \
    unzip gradle-4.10.2-bin.zip -d /opt && \
    rm gradle-4.10.2-bin.zip

RUN apt-get install -y curl


ENV GRADLE_HOME /opt/gradle-4.10.2
ENV PATH $PATH:/opt/gradle-4.10.2/bin
