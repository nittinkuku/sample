
###Copy Project to EC2 instance for deployment :

####Syntax of scp :
#####scp -i <path to pem file on local machine> <path to spring boot project or your deliverables>  user@remote_host_name:~
~ represents the home directory of the remote EC2 system.

#####scp -i C:\Users\nitti\Downloads\app\EC2KeyPairSample.pem C:\Users\nitti\Downloads\app\sample-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-224-22-177.us-east-2.compute.amazonaws.com:~