####Java Update :
sudo yum remove java-1.7.0-openjdk

sudo yum install java-1.8.0-openjdk

####Copy Jar :

scp -i C:\Users\nitti\Downloads\app\EC2KeyPairSample.pem C:\Users\nitti\Downloads\app\sample-0.0.1-SNAPSHOT.jar ec2-user@ec2-18-224-22-177.us-east-2.compute.amazonaws.com:~