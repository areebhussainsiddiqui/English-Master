package com.cognitive.englishmaster.model_classes;

public class Image_Idioms_Model {
    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }

    public String getSentence() {
        return Sentence;
    }

    public void setSentence(String sentence) {
        Sentence = sentence;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public Image_Idioms_Model(String heading, String meaning, String sentence, int image) {
        Heading = heading;
        Meaning = meaning;
        Sentence = sentence;
        Image = image;
    }

    private String Heading,Meaning,Sentence;
    private int Image;
}
