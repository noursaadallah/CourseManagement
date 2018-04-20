# Course Management

Download HSQLBD : https://sourceforge.net/projects/hsqldb/files/hsqldb/hsqldb_1_8_1/

Start hsqldb (in hsqldb/lib) : 
* java -cp hsqldb.jar org.hsqldb.Server

Start the DB manager (in hsqldb/lib) : 
* java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing 
(select type HSQL Database Engine server).

Build app: 
* Linux : ./gradlew build
* Windows : gradlew build

Convert to Eclipse : 
* Linux : ./gradlew eclise
* Windows : gradlew eclipse

Import to Eclipse : File ->  Import -> General -> Existing project into workspace...


##Docker

Build and Launch the docker image :
* docker build -t name .
* docker images
* docker run -p 4000:8080 -t hello
* docker container ls OR docker ps