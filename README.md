# BlockChainEmulation

## Prerequisites

- Java
- Vue CLI
- VSCode (or other IDE)
- BootstrapVue
- [Maven](https://www.journaldev.com/2348/install-maven-mac-os)

## Get Started

```
// clone the project
git clone https://github.com/Anders-Engman/BlockChainEmulation.git

// Run Vue on port 3000
cd /src/main/client
npm install
npm run serve

// Run Java Code on 8080
mvn clean install
java -jar target/blockchainemulator-0.0.1-SNAPSHOT.jar
```
//Spin up docker container
docker build -t blockchain_emulation .
docker run -p 8080:8080 blockchain_emulation
