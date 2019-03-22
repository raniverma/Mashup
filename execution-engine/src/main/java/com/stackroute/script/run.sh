#!/usr/bin/env bash
echo "inside the run.sh script "
echo $1
pwd
cd $2/$1
echo "printing the current directory"
pwd
echo "running maven package life cycle"
alias mvn='mvn  --quiet'
mvn test -l   compile.log
abc=$(grep -n "Tests run:" compile.log | cut -d: -f1 | head -1)
abc=$((abc-1))
sed "2,${abc}d" compile.log > compile2.log