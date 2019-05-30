package com.cognitive.englishmaster.model_classes;

public class AudioDetail
{
    private String title,statement1, statement2, statement3;

    public AudioDetail(String title, String statement1, String statement2, String statement3) {
        this.title = title;
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.statement3 = statement3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatement1() {
        return statement1;
    }

    public void setStatement1(String statement1) {
        this.statement1 = statement1;
    }

    public String getStatement2() {
        return statement2;
    }

    public void setStatement2(String statement2) {
        this.statement2 = statement2;
    }

    public String getStatement3() {
        return statement3;
    }

    public void setStatement3(String statement3) {
        this.statement3 = statement3;
    }
}
