Automation Scripts Execution Steps:
To execute test scripts please follow below steps:

1)	Install Java & maven and set their respective paths in system variables.

2)	Extract the zip file
4)	Open COMMAND PROMPT (cmd) 
5)	Navigate to the folder ‘MiroApp’
6)	Clean and compile project using
mvn clean compile
7)	To execute automation scripts, execute any of the following commands from command prompt:
i.	To execute all automation scripts (by default it will run on Chrome) mvn test
8)	Logs available in Log folder
9)	Test reports are available in below location
test-output\emailable-report
test-output\index.html
