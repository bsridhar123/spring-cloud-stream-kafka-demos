git reset --hard HEAD
git clean -xffd
git pull

 bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test
 
 bin/kafka-topics.sh --list --zookeeper localhost:2181
 
 bin/zookeeper-server-start.sh config/zookeeper.properties
 
 
  bin/kafka-server-start.sh config/server.properties
  bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
  bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
  git push -u origin master