# SprintFinalTeam

Final Sprint Project
December 2021
Team 3: Leon Chisholm, Lyndon Loveys, John O'Neill

CHANGE FRONT END CLIENT TO HTTP:// TO WORK!! http://team3.johnny-o.net/

This is a web application that authenticates and logs in a user who can then make GET requests
to two databases (one is a MySQL db, the other is a PostgreSQL db).
User credentials are stored in one of the databases.
The frontend is written in React JS.
The REST API is written in Java using the Spring Boot framework.

For the purpose of the assignment, the two databases set up as two RDS instances on AWS.
The application itself has been Dockerized, and the container runs on an AWS EC2 instance.

AWS EC2 instructions on access to EC2 (.pem file will be included in the Teams assignment submission):
Make sure to switch to directory containing .pem file before entering command
- ssh -i FinalSprint.pem ec2-user@ec2-3-92-38-37.compute-1.amazonaws.com

The EC2 is in the Learner labs account of Lyndon Loveys which has docker and our images installed.
Next, run the following commands:
- sudo service docker start
- docker run -d -it -p 8080:2000 ffccb0e3af24 -t myfirstapplication --net host

The docker file will boot and the test route that does not need authentication is http://3.92.38.37:8080/greeting

From here our front end client will work http://team3.johnny-o.net/

You will have to create an account to do any searches in either database.
Leave the search field empty and press search to see all the entries in the databases. 
Example searches in the Car Make option can include Ford, Chevy, Pontiac for Car Make MySql
