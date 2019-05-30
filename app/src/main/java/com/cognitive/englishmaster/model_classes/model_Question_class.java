package com.cognitive.englishmaster.model_classes;

public class model_Question_class {
    public model_Question_class() {

    }

    public model_Question_class(String question, String ans1, String ans2, String ans3, String ans4, String ans5, String Right_Ans) {
        Question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.ans5 = ans5;
        this.RightAns = Right_Ans;
    }

    public model_Question_class(String question, String ans1, String ans2, String ans3, String ans4,String RightAns) {
        Question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.RightAns = RightAns;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

   private String Question;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;

    public String getAns5() {
        return ans5;
    }

    public void setAns5(String ans5) {
        this.ans5 = ans5;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String RightAns;

    public String getRightAns() {
        return RightAns;
    }

    public void setRightAns(String rightAns) {
        RightAns = rightAns;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;
}
