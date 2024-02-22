#DEV

#Dowload postgreSQL image
FROM postgres:latest

#update system
RUN apt-get update -y && apt-get upgrade -y

#install postgreSQL modules
RUN apt-get install postgresql-contrib

#Copy SQL script to execute
COPY ./init.sql /docker-entrypoint-initdb.d/
COPY ./insert.sql /docker-entrypoint-initdb.d/
