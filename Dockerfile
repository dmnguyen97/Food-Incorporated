FROM ubuntu:14.04

# For install steps
USER root

RUN apt-get update \
    && apt-get upgrade \
    && apt-get dist-upgrade \
    && apt-get install --no-install-recommends \
      --no-install-suggests -y software-properties-common \
    && apt-get install -y unzip

RUN add-apt-repository --yes ppa:linuxuprising/java \
    && apt-add-repository --yes ppa:brightbox/ruby-ng \
    && apt-get update \
    && echo openjdk-11-jdk shared/accepted-oracle-license-v1-2 select true | debconf-set-selections \
    && apt-get install --no-install-recommends \
      --no-install-suggests -y openjdk-11-jdk \
    && apt-get install --no-install-recommends \
      --no-install-suggests -y oracle-java11-set-default

RUN sudo update-ca-certificates && \
    wget -q https://services.gradle.org/distributions/gradle-4.10.2-bin.zip && \
    unzip gradle-4.10.2-bin.zip -d /opt && \
    rm gradle-4.10.2-bin.zip

RUN apt-get install -y curl

ENV GRADLE_HOME /opt/gradle-4.10.2
ENV PATH $PATH:/opt/gradle-4.10.2/bin
