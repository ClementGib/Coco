## <u> Docker steps</u> 🐋

<p>Steps to launch all the containers usefull. Don't forget to securise them !</p>

#### requirement :
- jdk-11.0.10_linux-x64_bin.deb
- wildfly-preview-23.0.2.Final.zip
- postgresql-42.2.20.jar
<br>


### Postegre container (Dev) 🐘
📁 into the "postgres" directory
```bash 
docker build -t postgres-dev dev/
docker run -p 5430:5432/tcp --name postgres-coco-dev -e POSTGRES_PASSWORD=<my-password> -d postgres-dev

docker build -t postgres-test test/
docker run -p 5431:5432/tcp --name postgres-coco-test -e POSTGRES_PASSWORD=<my-password> -d postgres-test
```

__To change password__ : Login/Group Roles ➡️ Properties➡️  Definition ➡️ Password
⚠️<span style="color:red">Container database for production is not recommended.</span>⚠️

Servers are accessible with **pgAdmin** or **postgresql-client**:
```bash
#psql -h <ip> -p <port> -U <user> 
psql -h 192.168.1.50 -p 5430 -U postgre 
```
<br>

### pgAdmin container 🧿
from *dpage/pgadmin*
```bash 
docker run -p 8081:80 -e 'PGADMIN_DEFAULT_EMAIL=<my-email>' -e 'PGADMIN_DEFAULT_PASSWORD=<my-password>' -d --name=ui-pgadmin dpage/pgadmin4
```

__To change password__ : "my-email@gmail.com" ➡️ Change password

<p>pgAdmin is accessible with localhost:8081</p>

1. Add server **postgres-dev** ➡️ **Host name/address** : <your-ip> ➡️ **Port** : 5430 ➡️ **Username** : postgres ➡️ **Password** : \<my-password\>

2. Add server **postgres-test** ➡️ **Host name/address** : <your-ip> ➡️ **Port** : 5431 ➡️ **Username** : postgres ➡️ **Password** : \<my-password\>

<br>
    
### Wildfly 23.0.2.Final server ☕
📁 into the "docker" directory

```bash 
docker build -t wildfly23 wildfly23/
#expose web application
docker run -p 8180:8080 --name wildflycoco -d wildfly23
#expose web application & wildfly admin interface 
docker run -p 8180:8080 -p 9990:9990 --name wildflycoco -d wildfly23
#expose web application and launch standalone.xml with the wildfly name version
docker run -p 8180:8080 --name wildflycoco -d wildfly23 /opt/jboss/wildfly-preview-23.0.2.Final/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0
```

.1 **Postgres driver installation :** 
- _(Optional)_ change module name in the **module.xml** file (by default postgresql-42.2.20.jar)
- copy the file postgresql module **.jar** in _/org/postgresql/main/_ (by default postgresql-42.2.20.jar)
- copy the file **module.xml** in _/org/postgresql/main/_

**standalone.xml configuration for the datasources :** xa-datasource
```xml
<subsystem xmlns="urn:jboss:domain:datasources:6.0">
    <datasources>
        <xa-datasource jndi-name="java:jboss/jdbc/COCO_DS" pool-name="CocoDSDev" enabled="true" use-java-context="true" spy="true">
            <xa-datasource-property name="ServerName">
                <!--ip-->
            </xa-datasource-property>
            <xa-datasource-property name="PortNumber">
                <!--port-->
            </xa-datasource-property>
            <xa-datasource-property name="DatabaseName">
                <!--database-->
            </xa-datasource-property>
            <driver>postgresql</driver>
            <transaction-isolation>TRANSACTION_REPEATABLE_READ</transaction-isolation>
            <security>
                <user-name><!--user--></user-name>
                <password><!--password--></PASSWORD>
            </security>
            <validation>
                <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
                <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
            </validation>
        </xa-datasource>
    </datasources>
</subsystem>
```
<br>
<br>

*Usefull :*
```bash 
#check
docker images #check images
docker ps # container list
docker ps -a # container history
docker container ls 

#build
docker build -t <image-name>

#debug containers
docker run -it -p 8180:8080 --name wildflycoco -d wildfly23
docker exec -it wildfly /bin/bash

#remove
docker image rm -f <image-name> #remove image with force
docker rmi -f <image-id> #remove image
```
