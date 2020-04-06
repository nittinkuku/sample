####Java Update :
sudo yum remove java-1.7.0-openjdk

sudo yum install java-1.8.0-openjdk

####MySql Installation
yum install mysql-server

chkconfig mysqld on

service mysqld start

mysqladmin -u root password [your_new_pwd]

mysql -uroot -p

show databases;

create database sample;

use sample;

####Copy Jar :

scp -i C:\Users\nitti\Downloads\app\EC2KeyPairSample.pem C:\Users\nitti\Downloads\app\sample-0.0.1-SNAPSHOT.jar ec2-user@ec2-3-16-183-7.us-east-2.compute.amazonaws.com:~

