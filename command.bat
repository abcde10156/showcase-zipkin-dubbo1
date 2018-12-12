.\bin\windows\kafka-server-start.bat .\config\server.properties
.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic zipkin
.\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181

