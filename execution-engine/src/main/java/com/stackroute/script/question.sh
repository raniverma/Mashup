#!/usr/bin/env bash

repository=$1
username=$2
mkdir $3/$2/questionplate

cd $3/$2/questionplate
mkdir abc

git clone "$repository" abc
echo  $1


rm $3/$2/src/main/java/com/stackroute/*.java
rm $3/$2/src/test/java/com/stackroute/*est.java
cd $3/$2/questionplate
a=`find  . -name '*.java'`
b=`find  . -name '*est.java'`
echo $b
echo bhaaak1
echo $a

echo " "
echo "printing in the question.sh file ..........."
echo "bhaak"
for  i in $a
do
if [ $i != $b ]
then
echo $i
echo "bhaak"

cp $3/$2/questionplate/$i $3/$2/src/main/java/com/stackroute
fi
done
echo
cp $3/$2/questionplate/$b  $3/$2/src/test/java/com/stackroute
rm -r $3/$2/questionplate
cd ../

echo "ye hai aapki directory"
echo $PWD

echo "running question.sh finished successfully"

a="docker run --rm -v $PWD:$PWD -w $PWD -v ~/.m2:/root/.m2 -w $PWD -v /var/run/docker.sock:/var/run/docker.sock maven:3 mvn clean test --quiet -l compile.log"
#echo root123|sudo -S chmod -R 777 ~
nodemon -L --watch $3/$2/src/main/java/com/stackroute/*.java --exec "$a" &
echo "hello friends"
echo $!> processid.log

