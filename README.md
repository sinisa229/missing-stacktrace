mvn clean install

java -jar ./target/missing-stacktrace-0.0.1-SNAPSHOT.jar

java -XX:-OmitStackTraceInFastThrow -jar ./target/missing-stacktrace-0.0.1-SNAPSHOT.jar