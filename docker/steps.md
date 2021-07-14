## <u> Docker steps</u> 🐋
<p>Steps to launch all the containers usefull. Don't forget to securise them !</p>
<br>


### Postegre container (Dev) 🐘
📁 into the "postgres" directory
```bash 
docker build -t postgres-dev dev/
docker run -p 5430:5432/tcp --name postgres-coco-dev -e POSTGRES_PASSWORD=<my-password> -d postgres-dev

docker build -t postgres-test test/
docker run -p 5431:5432/tcp --name postgres-coco-test -e POSTGRES_PASSWORD=<my-password> -d postgres-test
```

__Change password after__ : Login/Group Roles ➡️ Properties➡️  Definition ➡️ Password
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

__Change password after__ : "my-email@gmail.com" ➡️ Change password

<p>pgAdmin is accessible with localhost:8080</p>

1. Add server **postgres-dev** ➡️ **Host name/address** : <your-ip> ➡️ **Port** : 5430 ➡️ **Username** : postgres ➡️ **Password** : \<my-password\>

2. Add server **postgres-test** ➡️ **Host name/address** : <your-ip> ➡️ **Port** : 5431 ➡️ **Username** : postgres ➡️ **Password** : \<my-password\>

<br>

### Wildfly server ☕
📁 into the "docker" directory

```bash 
docker build -t wildfly22 wildfly22/
#expose web application
docker run -p 8180:8080 --name wildflycoco -d wildfly22
#expose web application & wildfly admin interface 
docker run -p 8180:8080 -p 9990:9990 --name wildflycoco -d wildfly22
```