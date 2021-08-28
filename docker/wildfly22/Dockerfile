#Wildfly image
FROM ubuntu:latest

#Config 
RUN apt-get update -y && apt-get upgrade -y

#Setup WildFly
COPY wildfly-22.0.0.Final-Coco /opt/wildfly
COPY standalone.xml /opt/wildfly/standalone/configuration
RUN rm -rf /opt/wildfly/standalone/configuration/standalone_xml_history/current/*
#RUN chown -R jboss:jboss /opt/wildfly/


#Setup Java
RUN mkdir /opt/java
COPY jdk-13.0.2_linux-x64_bin.tar.gz /opt/java/

# change dir to Java installation dir
WORKDIR /opt/java/ 
RUN tar -zxf jdk-13.0.2_linux-x64_bin.tar.gz
ENV JAVA_HOME jdk-13.0.2
RUN export JAVA_HOME

# setup environment variables
RUN update-alternatives --install /usr/bin/javac javac /opt/java/jdk-13.0.2/bin/javac 100 
RUN update-alternatives --install /usr/bin/java java /opt/java/jdk-13.0.2/bin/java 100

RUN update-alternatives --display java 

# install application 
#COPY myApplication.war /opt/wildfly/standalone/deployments


# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface

CMD ["/opt/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]
#CMD ["/opt/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0"]


# Expose the ports : web application & wildfly admin interface 
EXPOSE 8080 9990 
# Expose the ports : web application
#EXPOSE 8080 9990 