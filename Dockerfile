FROM amd64/openjdk

COPY ./target/blockchainemulator-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","blockchainemulator-0.0.1-SNAPSHOT.jar"]
