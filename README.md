# Poker hands evaluator

# Execution Environment

JRE 8 is required for running this application.

# Execution details

The application contains a desktop UI.  
The executable jar file is placed under the target directory. Please download it from there. 
Double clicking the file should launch the application. The application has a desktop client.

If there are problems launchng the application with double clicks, then it could be also launched from command line as

    java -jar PokerHandEvaluator.jar

For generating a new executable jar file, maven would be required. Please execute the following command from command line to create a new executable jar if required. 

    mvn clean compile assembly:single

# Application details

Two hands can be compared at a time. Either "Distribute / Redistribute" button on the UI can be used to distribute cards or cards could be typed in the text boxes manually.
Each hand is drawn from one deck at a time. Two decks can be used as well.
Appropriate validations are added.

Result is displayed in the Result panel.
