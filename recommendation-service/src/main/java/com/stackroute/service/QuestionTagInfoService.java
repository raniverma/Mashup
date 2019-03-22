package com.stackroute.service;

import com.stackroute.model.Question;
import com.stackroute.model.QuestionTagInfo;
import com.stackroute.repository.QuestionTagRepository;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
//Beginner
//        Intermediate
//        Advanced

@Service
public class QuestionTagInfoService {
    @Autowired
    QuestionTagRepository tagInfoRepository;
    @Autowired
    UserRepository questionRepository;

    public void saveQuestion(Question qs) {
        System.out.println(qs.getQuestionId() + qs.getQuestionTitle() + qs.getDifficulty() + qs.getTags());
        questionRepository.saveQuestion(qs.getQuestionId(), qs.getQuestionTitle(), qs.getDifficulty(), qs.getTags());
        questionRepository.mapOntology(qs.getQuestionId());
    }

    public QuestionTagInfo copyTag(QuestionTagInfo qt) {
        QuestionTagInfo qt1 = new QuestionTagInfo();
        qt1.set_id(qt.get_id());
        qt1.setRatio(qt.getRatio());
        qt1.setDate(qt.getDate());
        qt1.setTagName(qt.getTagName());
        qt1.setUsername(qt.getUsername());
        qt1.setTotalHardPoints(qt.getTotalHardPoints());
        qt1.setTotalEasyPoints(qt.getTotalEasyPoints());
        qt1.setTotalMediumPoints(qt.getTotalMediumPoints());
        qt1.setTotalQuestions(qt.getTotalQuestions());
        qt1.setLevelRatio(qt.getLevelRatio());
        return qt1;

    }

    public void addTags(String[] tagList, String userName) {
        if (tagList != null)
            for (String tag : tagList)
                if (tagInfoRepository.getByUsernameAndTagName(userName, tag) == null) {    // System.out.println();
                    QuestionTagInfo questionTagInfo = new QuestionTagInfo();
                    questionTagInfo.setRatio("10:10:10");
                    questionTagInfo.setDate(new Date());
                    questionTagInfo.setTagName(tag);
                    questionTagInfo.setUsername(userName);

                    // tagInfoRepository
                    tagInfoRepository.save(questionTagInfo);
                }

        int size = tagInfoRepository.getByUsername(userName).size();
        String tagArray[] = {"Loops", "Conditional Statements", "Graph", "ArrayList", "If Statement", "LinkedList"};
        int index = 0;
        while (size < 6) {
            if (tagInfoRepository.getByUsernameAndTagName(userName, tagArray[index]) == null) {
                QuestionTagInfo questionTagInfo = new QuestionTagInfo();
                questionTagInfo.setRatio("10:10:10");
                questionTagInfo.setDate(new Date());
                questionTagInfo.setTagName(tagArray[index]);
                questionTagInfo.setUsername(userName);
                size++;
                tagInfoRepository.save(questionTagInfo);
            }

            index++;


        }
    }


    public List<Question> getUserQuestions(String uname) {

        List<QuestionTagInfo> tagList = tagInfoRepository.getByUsername(uname);
        System.out.println("TAGLIST : " + tagList);

        if (tagList == null || tagList.size() == 0)
            return null;
        for (QuestionTagInfo qt1 : tagList) {
            System.out.println(qt1.get_id() + qt1.getTagName());
        }
        Date date = new Date();
        tagList.sort(new Comparator<QuestionTagInfo>() {

            @Override
            public int compare(QuestionTagInfo o1, QuestionTagInfo o2) {
                if (o1.getDate().getYear() != o1.getDate().getYear()) {
                    return (o2.getDate().getYear() - o1.getDate().getYear());
                } else if (o2.getDate().getMonth() != o1.getDate().getMonth())
                    return (o2.getDate().getMonth() - o1.getDate().getMonth());
                else
                    return (o2.getDate().getDay() - o1.getDate().getDay());

            }
        });

        int total = 0;
        int index = 0;
        int easy, medium, hard;
        List<Question> questionList = new ArrayList<Question>();
        Question randomQuestion;
        while (index < 6) {
            String level[] = tagList.get(index).getRatio().split(":");
            easy = Integer.valueOf(level[0]);
            medium = Integer.valueOf(level[0]);
            hard = Integer.valueOf(level[2]);
            if (easy >= medium && easy >= hard) {
                int t = 0;

                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Beginner", uname);
//                    System.out.println(randomQuestion.getQuestionTitle()+randomQuestion);
                if (randomQuestion != null) {
                    questionList.add(randomQuestion);
                    System.out.println(randomQuestion.getQuestionTitle());
                }

                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Intermediate", uname);
                if (randomQuestion != null)
                    questionList.add(randomQuestion);


            } else if (medium >= easy && medium >= hard) {


                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Intermediate", uname);
                if (randomQuestion != null)
                    questionList.add(randomQuestion);

                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Advanced", uname);
                if (randomQuestion != null)
                    questionList.add(randomQuestion);


            } else {
                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Advanced", uname);
                if (randomQuestion != null)
                    questionList.add(randomQuestion);
                randomQuestion = questionRepository.getQuestionByTag(tagList.get(index).getTagName(), "Advanced", uname);
                if (randomQuestion != null)
                    questionList.add(randomQuestion);


            }
            index++;

        }
        if (questionList == null || questionList.size() == 0) {
            System.out.println("you are getting zero recommendation");
        }

        for (Question ques : questionList) {
            System.out.println("QUESTION : " + ques);
        }
        return questionList;

    }

    public int questionInList(Question randomQuestion, List<Question> questionList) {
        int m = 0;
        for (Question qt : questionList) {
            if (qt.getId() == randomQuestion.getId()) {
                m = 1;
            }
        }
        return m;

    }

    public void setLevelVal(Double maxscore, Double score, String abc, String currentlevel, QuestionTagInfo questionTagInfo) {

        if (currentlevel.toString().equals("Intermediate"))
            score = score / 2;
        if (currentlevel.toString().equals("Advanced"))
            score = score / 3;

        String arr[] = abc.split("[:\"]");


        int easy = Integer.parseInt(arr[0]);
        int medium = Integer.parseInt(arr[1]);
        int hard = Integer.parseInt(arr[2]);


        if (score > maxscore) {
            maxscore = score;
            if (score == 9 || score == 10) {
                if (currentlevel.toString().equals("Beginner")) {
                    medium++;
                    if (easy >= 1)
                        easy--;

                } else if (currentlevel.toString().equals("Intermediate")) {
                    if (easy >= 1)
                        easy--;
                    hard++;
                } else {
                    hard++;
                    if (easy >= 1)
                        easy--;
                }
            } else if (score >= 0 && score <= 6) {
                if (hard >= 1)
                    hard--;
                if (currentlevel.toString().equals("Intermediate")) {
                    easy++;

                } else if (currentlevel.toString().equals("Beginner")) {
                    easy++;

                } else {
                    medium++;

                }
            } else {
                if (currentlevel.toString().equals("Intermediate")) {
                    medium++;
                    if (easy >= 1)
                        easy--;
                } else if (currentlevel.toString().equals("Beginner")) {
                    easy++;
                    if (hard >= 1)
                        hard--;
                } else {
                    hard++;
                    if (easy >= 1)
                        easy--;
                }
            }
            questionTagInfo.setRatio(easy + ":" + medium + ":" + hard);
        }
        // write command to change max score


    }

    public void addOrUpdateTag(String qid, double score, String username) {
        QuestionTagInfo qt1;
        double maxscore;
        Question q1 = questionRepository.findquestionbyId(qid);
        QuestionTagInfo tagInfo2 = tagInfoRepository.getByUsernameAndTagName(username, q1.getTags());
        //  tagInfoRepository.delete(tagInfo2);
        if (questionRepository.getScore(username, qid) == null) {
            questionRepository.createConnection(username, qid, score);
            maxscore = 0.0;
        } else {
            maxscore = questionRepository.getScore(username, qid);
            if (maxscore < score)
                questionRepository.setScore(username, qid, score);
            else
                return;
        }
        for (QuestionTagInfo tagInfo : tagInfoRepository.getByUsername(username)) {


            try {
                System.out.println(tagInfo.getTagName() + q1.getTags());
                if (questionRepository.areNodeConnected(tagInfo.getTagName(), q1.getTags())) {
                    qt1 = copyTag(tagInfo);
                    tagInfoRepository.delete(qt1);
                    setLevelVal(maxscore, score, tagInfo.getRatio(), q1.getDifficulty(), tagInfo);
                    tagInfo.setTotalQuestions(tagInfo.getTotalQuestions() + 1);
                    if (maxscore == 0.0) {
                        if (q1.getDifficulty().toString().equals("Beginner")) {
                            tagInfo.setTotalEasyPoints(tagInfo.getTotalEasyPoints() + score);
                        } else if (q1.getDifficulty().toString().equals("Intermediate")) {

                            tagInfo.setTotalMediumPoints(tagInfo.getTotalEasyPoints() + score);
                        } else {

                            tagInfo.setTotalHardPoints(tagInfo.getTotalEasyPoints() + score);
                        }
                    }

                    tagInfo.setDate(new Date());
                    //  tagInfoRepository.delete();
                    tagInfoRepository.save(tagInfo);
                }
            } catch (Exception e) {
                System.out.println(e.getCause());
            }


        }
        if (tagInfo2 == null) {

            tagInfo2 = new QuestionTagInfo();
            tagInfo2.setTotalQuestions(1);
            tagInfo2.setUsername(username);
            tagInfo2.setTagName(q1.getTags());
            tagInfo2.setRatio("10:10:10");
            if (q1.getDifficulty().toString().equals("Beginner")) {
                tagInfo2.setTotalEasyPoints(score);
            } else if (q1.getDifficulty().toString().equals("Intermediate")) {
                tagInfo2.setTotalMediumPoints(score);
            } else {
                tagInfo2.setTotalHardPoints(score);
            }
            setLevelVal(maxscore, score, tagInfo2.getRatio(), q1.getDifficulty(), tagInfo2);
            tagInfo2.setDate(new Date());
            tagInfoRepository.save(tagInfo2);
        } else {
            qt1 = copyTag(tagInfo2);
            try {
                tagInfoRepository.delete(qt1);
            } catch (Exception it) {
                System.out.println(it.getCause());
                // System.out.println(it);
            }
            setLevelVal(maxscore, score, tagInfo2.getRatio(), q1.getDifficulty(), tagInfo2);
            tagInfo2.setTotalQuestions(tagInfo2.getTotalQuestions() + 1);
            tagInfo2.setDate(new Date());
            if (maxscore == 0.0) {
                if (q1.getDifficulty().toString().equals("Beginner")) {
                    tagInfo2.setTotalEasyPoints(tagInfo2.getTotalEasyPoints() + score);
                } else if (q1.getDifficulty().toString().equals("Intermediate")) {
                    tagInfo2.setTotalMediumPoints(tagInfo2.getTotalEasyPoints() + score);
                } else {
                    tagInfo2.setTotalHardPoints(tagInfo2.getTotalEasyPoints() + score);
                }
            }


            tagInfoRepository.save(tagInfo2);
        }

    }


}
