package com.stackroute.repository;


import com.stackroute.model.Question;
import com.stackroute.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//LOAD CSV WITH HEADERS FROM "file:///question-seedData.csv" as line
@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {


    @Query("create (:Question { questionId:{questionId}, questionTitle:{questionTitle},difficulty:{difficulty},tags:{tags}})")
 public void saveQuestion(@Param("questionId") String questionId,@Param("questionTitle") String questionTitle, @Param("difficulty") String difficulty, @Param("tags") String tags);


    @Query("MATCH (child:Question{ questionId:{questionId}})\n" +
        "WITH (child)\n" +
        "MATCH(parent:Ontology)\n" +
        "WHERE parent.tag = child.tags\n" +
        "CREATE (parent)-[:part_of]->(child)")
public void mapOntology(@Param("questionId") String questionId);

    @Query("match (a:User{username:{username}})-[r:attempted]->(b:Question{questionId:{questionId}})\n" +
            "return r.score")
    public Double getScore(@Param("username") String username, @Param("questionId") String questionId);

    @Query("MATCH  (p:Ontology{tag:{parent}}), (b:Ontology{tag:{child}})\n" +
            "RETURN EXISTS( (p)-[:subconcept_of]->(b) )")
    public Boolean areNodeConnected(@Param("parent") String parent, @Param("child") String child);

    @Query(" MATCH (u:User{username:{username}})-[r:attempted]->(q:Question{questionId:{questionId}}) SET r.score={score}")
   public void setScore(@Param("username") String username, @Param("questionId") String questionId, @Param("score") Double score);

   @Query(" MATCH (u:User{username:{username}}),(q:Question{questionId:{qid}})\n"+
    "CREATE (u)-[:attempted{score:{score}}]->(q)")
    public  void createConnection(@Param("username") String username, @Param("qid") String qid, @Param("score") Double score);



    @Query("MATCH (n:Ontology{tag:{tagName}})-[:part_of]->(t:Question{difficulty:{Level}}) WHERE NOT (t)<-[:attempted]-(:User{username:{username}}) WITH t, rand() AS r ORDER BY r RETURN t LIMIT 1")
    public Question getQuestionByTag(@Param("tagName") String tagName, @Param("Level") String Level, @Param("username") String username);

    // Get all functions

    @Query("MATCH (u:User) RETURN u")
    List<User> getAllUsers();

    @Query("MATCH (n:Question) RETURN n")
    List<Question> getAllQuestions();


    //@Query("MATCH (u:User)<-[a:ATTEMPTED]-(q:Question) RETURN u,a,q")
    //List<User> getAllUsersRelations();


    @Query("MATCH (n:User{username:{username}}) detach DELETE n")
    User delete(@Param("username") String username);

    @Query("MATCH (u:User{username:'bhaak2'}) RETURN u")
    User findByUsername(@Param("username") String username);

    @Query("MATCH (q:Question{questionId:{questionId}}) return q")
    Question findquestionbyId(@Param("questionId") String questionId);

//    @Query("CREATE(question:Question{questionId:{questionId},questionTitle:{questionTitle},difficulty:{difficulty},tags:{tags}})")
//    Question saveQuestion(@Param("questionId") String questionId,@Param("questionTitle") String questionTitle,@Param("difficulty") String difficulty,@Param("tags") String tags);

//    @Query("MATCH (q:Question{questionId:{questionId}}) SET q.questionTitle={questionTitle} SET q.difficulty={difficulty} SET q.tags={tags}")
//    Question updateQuestionNode(@Param("questionId") String questionId,@Param("questionTitle") String questionTitle,@Param("difficulty") String difficulty,@Param("tags") String tags);


}
