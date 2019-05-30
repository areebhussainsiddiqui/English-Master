package com.cognitive.englishmaster.model_classes;

public class Word_Model_Class {
    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getDefination() {
        return Defination;
    }

    public void setDefination(String defination) {
        Defination = defination;
    }

    public String getExample() {
        return Example;
    }

    public void setExample(String example) {
        Example = example;
    }

    public String getUrdu_Meaning() {
        return Urdu_Meaning;
    }

    public void setUrdu_Meaning(String urdu_Meaning) {
        Urdu_Meaning = urdu_Meaning;
    }

    public int getWord_Image() {
        return Word_Image;
    }

    public void setWord_Image(int word_Image) {
        Word_Image = word_Image;
    }

    public Word_Model_Class() {
    }

    public Word_Model_Class(String word, String meaning, String sentences, int word_Image) {
        Word = word;
        Defination = meaning;
        Example = sentences;
//        Urdu_Meaning = urdu_Meaning;
        Word_Image = word_Image;
    }

    String Word;
    String Defination;
    String Example;
    String Urdu_Meaning;
    int Word_Image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
}
