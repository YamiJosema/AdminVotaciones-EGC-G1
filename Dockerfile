# Pull base image
From tomcat:7-jre7

# Maintainer
MAINTAINER "YamiJosema <josemapallero29@gmail.com>"

RUN rm -rf /usr/local/tomcat/webapps/*

# Copy to images tomcat path
ADD ROOT.war /usr/local/tomcat/webapps/.