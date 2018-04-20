*************************************************************************
To launch HSQLDB : 

move to the directory of HSQLDB and open two terminals :

Launch the server :
	java -cp hsqldb.jar org.hsqldb.Server
	
Launch the database manager :
	java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
	
	!! Select Type : HSQL Database Engine Server
*************************************************************************
Build and Launch the docker image :
	docker build -t hello .
	docker images
	docker run -p 4000:8080 -t hello
	docker container ls OR docker ps