#!/usr/bin/env bash
#cd /home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-boilerplate
cd /DB/js-boilerplate
alias mvn='mvn  --quiet'
mvn clean package -DskipTests -l compile.log
#if [ -s /home/user/Documents/Mashup/aws-v1.0.4/boeing-wave3-mashup/js-boilerplate/compile.log ]
if [ -s /DB/js-boilerplate/compile.log ]
then
    echo "not empty " >> compile.log
else
    echo "output =>" > compile.log
    a="/DB/js-boilerplate/target/execution-engine-1.0-SNAPSHOT.jar"
    java -jar $a >> compile.log 2>&1
fi
