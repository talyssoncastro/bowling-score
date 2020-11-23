# Bowling Game
The goal of this project is to read and print scores for a bowling game

### pre-requisites
* JDK 8 or higher

### Running
This project has been using maven as a build automation tool. 
If you type ```./mvnw clean install``` it will download all necessary dependencies (even Maven), clear the target directory, compile the entire project and also run all tests.

To run the project providing a file as input data, just execute the jar on the target folder specifying the path for the input file. For instance: ```java -jar bowling-game.jar ../jeff_john.txt```