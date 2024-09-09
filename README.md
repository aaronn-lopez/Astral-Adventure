# ASTRAL ADVENTURE

#### Java Version - openjdk-21

## Running the Game with Maven
### How to Run the Game with Maven
- Ensure Maven and Java are added to your PATH
- In the terminal, navigate to the project path
- Execute the command: "mvn compile exec:java -D exec.mainClass="Game.Main"" to compile and run the game

### How to test the Game with Maven
- In the terminal, navigate to the project path
- Execute the command: "mvn test" to run all tests

## Running the Game in IntelliJ
### How to run the game:
- Ensure Maven and IntelliJ is installed
- Open the project
- Create a new Application Run Configuration and select 'Main' as the main class

- Run the project

### How to test the game:
- Ensure Maven and IntelliJ is installed
- Open the project
- Create a new JUnit Run Configuration
- Change 'class' to 'All in directory'
- Choose src/test/java as the directory
- Run the test
- (Optional) Click the three dots near the run button, and select 'Run with Coverage'

## Documentation
### Buidling Javadocs
- Execute mvn javadoc:jar to automatically create the javadocs
