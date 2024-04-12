# CMPT276S24_group10

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
![image](https://media.github.sfu.ca/user/2404/files/334d6a87-42ef-431f-af2d-dc8af2a17bcb)
- Run the project

### How to test the game:
- Ensure Maven and IntelliJ is installed
- Open the project
- Create a new JUnit Run Configuration
- Change 'class' to 'All in directory'
- Choose src/test/java as the directory
![image](https://media.github.sfu.ca/user/2404/files/31c11186-d73c-4b60-8e78-d077d479a712)
- Run the test
- (Optional) Click the three dots near the run button, and select 'Run with Coverage'
