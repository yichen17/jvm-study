mkdir ./logs
nohup java -Xms512m -Xmx512m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./heapdump.dump -jar jvm-study-0.0.1-SNAPSHOT.jar > ./logs/test.log 2>&1  &