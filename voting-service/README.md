# Voting service - Spring Boot with MongoDB
This service allows user to upvote or downvote questions attempted by him/her.

## Version used
- Spring Boot - 1.5.14.RELEASE
- MongoDB

## REST endpoint
- `/api/h/upvoted/{questionId}` - returns list of Vote domain {questionId,userName,voteStatus} where particular question is upvoted.
- `/api/h/downvoted/{questionId}` - returns list of Vote domain {questionId,userName,voteStatus} where particular question is downvoted.
- `/api/h/listvoted/{userName}` - returns list of Vote domain {questionId,userName,voteStatus} where these are voted by a particular user.
- `/api/h/votestatus/{questionId}/{userName}` - returns list of Vote domain {questionId,userName,voteStatus} where it show voteStatus of particular question by particular user.
