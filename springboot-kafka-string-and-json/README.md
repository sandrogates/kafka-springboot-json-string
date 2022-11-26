In this project, I have worked with SPRINGBOOT + KAFKA. Processing messages via JSON or native String.

How to work with this project :

1- Download the entire project, unzip it and import it in Eclipse J2EE.

2- Install all dependencies in the pom.xml file.

3- Install kafka_2.12-3.3
   Example on windows: C:\Data\kafka_2.12-3.3.1

4- Start the zookeeper:
   Example on windows:
   cd \Data\kafka_2.12-3.3.1\bin\windows
   zookeeper-server-start.bat ../../config/zookeeper.properties
   
5- Start the kafka:
   Example on windows:
   cd \Data\kafka_2.12-3.3.1\bin\windows
   kafka-server-start.bat ../../config/server.properties   
   
   5.1 - On Linux it would be something like /opt/kafka
         cd /opt/kafka_2.12-3.3.1/bin

6- in the eclipse, Run main class DotingJavaSampleApplication
   will run Springboot on the 8080
   
7- Send string to kafka 
   http://localhost:8080/api/dotingjava/kafka/publish_string?message=TEST_DOTING_JAVA
   or
   curl -X GET http://localhost:8080/api/dotingjava/kafka/publish_string?message=TESTE_DOTING_JAVA   
   
8- Send json to kafka   
   curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d "{\"from\":\"Sandro Lemanski da Silva\",\"subject\":\"Springbook+kafka\",\"to\":\"sandrogates@gmail.com\",\"message\":\"Hi, this works\"}" http://localhost:8080/api/dotingjava/kafka/publish_json
   
     
I hope it has some use
Tks
sandrogates@gmail.com
