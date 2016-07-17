## Poker Hands Evaluator

### Execution Environment

JRE 8 is required for running this application.

### Execution details

The executable jar file is placed under the target directory. Please download it from there. 
Double clicking the file should launch the application. The application has a desktop client.

If there are problems launchng the application with double clicks, then it could be launched from command line as well using the below mentioned command.

    java -jar PokerHandEvaluator.jar

Log file would be generated in the directory where the jar is executed.

If necessary for generating a new executable jar file, maven would be required. Please execute the following command from command line to create a new executable jar. 

    mvn clean compile assembly:single

### Application details

Two hands can be compared at a time. Either "Distribute / Redistribute" button on the GUI can be used to distribute cards or cards could be typed in the text boxes manually.
Each hand is drawn from one deck at a time. Two decks can be used as well.
Appropriate validations are added.

Result is displayed in the Result panel. Both hands are programatically fully evaluated. 

The result shows the winning hand along with other details associated with it.
