#Wildfly image
FROM ubuntu:latest

#Config 
RUN apt-get update -y && apt-get upgrade -y
RUN apt-get install unzip libasound2 -y

USER root
RUN groupadd -r jboss -g 1000 && useradd -u 1000 -r -g jboss -m -d /opt/jboss -s /sbin/nologin -c "JBoss user" jboss && \
    chmod 755 /opt/jboss

#Environment variable
USER jboss
ARG WILDFLY_VERSION=wildfly-preview-23.0.2.Final
ARG POSTGRES_MODULE=postgresql-42.2.20.jar
ARG JDK_FILE=jdk-11.0.10_linux-x64_bin
ARG JDK_VERSION=jdk-11.0.10
ENV JAVA_HOME=/usr/lib/jvm/${JDK_VERSION}
ENV WILDFLY_HOME=${WILDFLY_VERSION}
ENV JBOSS_HOME=/opt/jboss/${WILDFLY_VERSION}

#Setup WildFly
WORKDIR /opt/jboss/
COPY ${WILDFLY_VERSION}.zip /opt/jboss/${WILDFLY_VERSION}.zip
RUN unzip /opt/jboss/${WILDFLY_VERSION}.zip
RUN rm -rf /opt/jboss/${WILDFLY_VERSION}.zip
COPY standalone.xml /opt/jboss/${WILDFLY_VERSION}/standalone/configuration

WORKDIR /opt/jboss/${WILDFLY_VERSION}/modules
RUN mkdir -p org/postgresql/main
COPY $POSTGRES_MODULE org/postgresql/main/$POSTGRES_MODULE
COPY module.xml org/postgresql/main/module.xml
#RUN chown -R jboss:jboss /opt/jboss/

USER root
#Setup Java
#RUN mkdir /opt/java
COPY ${JDK_FILE}.deb /opt/java/
WORKDIR /opt/java/
RUN dpkg -i ${JDK_FILE}.deb

# change dir to Java installation dir already done with dpkg -i
#WORKDIR /usr/lib/jvm/
#RUN tar -zxf ${JDK_VERSION}.gz
#equal to jdk-11.0.10
#ENV JAVA_HOME ${JDK_VERSION}
#RUN export JAVA_HOME

# setup environment variables
RUN update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/${JDK_VERSION}/bin/javac 100 
RUN update-alternatives --install /usr/bin/java java /usr/lib/jvm/${JDK_VERSION}/bin/java 100

RUN update-alternatives --display java 

#The server is run as the jboss user which has the uid/gid set to 1000.
USER jboss

# install application 
#COPY myApplication.war /opt/jboss/standalone/deployments

# Expose the ports : web application & wildfly admin interface 
EXPOSE 8080 9990 
# Expose the ports : web application
#EXPOSE 8080 9990 

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
#CMD ["sh","-c","opt/jboss/$WILDFLY_HOME/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]
CMD ["/opt/jboss/wildfly-preview-23.0.2.Final/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
#CMD ["sh","-c","/opt/jboss/wildfly-preview-23.0.2.Final/bin/standalone.sh", "-b", "0.0.0.0"]
#CMD ["/opt/jboss/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0"]

