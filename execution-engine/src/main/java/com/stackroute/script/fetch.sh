#!/usr/bin/env bash
echo $1

repository=$1
username=$2

mkdir $3/$2
cd  $3/$2
cd ../


echo "printing in the fetch.sh file ...."

git clone "$repository"  $2

echo "running fetch.sh finished successfully"