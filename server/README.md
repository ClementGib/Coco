## Procedure project:

1. Création du pom.xml parent:
```bash
mvn archetype:generate -DgroupId=com.clement.gibert.coco -DartifactId=coco-back
```

```xml

  <groupId>com.clement.gibert</groupId>
  <artifactId>coco</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <name>coco</name>
  <url>http://www.clement-gibert.com/</url>


<packaging>pom</packaging>

<!-- <modules>
	<module>api</module>
	<module>ws</module>
	<module>service</module>
	<module>deploy</module>
</modules> -->

```

2. Création des modules maven :
```bash
cd coco-back
mvn archetype:generate -DgroupId=com.clement.gibert.coco  -DartifactId=api
mvn archetype:generate -DgroupId=com.clement.gibert.coco  -DartifactId=ws
mvn archetype:generate -DgroupId=com.clement.gibert.coco -DartifactId=service
mvn archetype:generate -DgroupId=com.clement.gibert.coco -DartifactId=deploy
```

## Procedure server:

1. Installation JDK
```bash
sudo dpkg -i jdk-13.0.2_linux-x64_bin.deb
```


2. Mise en place et tests du server
```bash
unzip server
$ ./wildfly-22.0.0.Final/bin/add-user.sh -u 'NAME_USER' -p 'PASSWORD!' 
```

2. Installation postegre SQL, démarrage et vérification:
```bash
sudo apt install postgresql postgresql-contrib
sudo service postgresql start
sudo -u postgres psql -c "SELECT version();"
```

