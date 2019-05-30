package com.cognitive.englishmaster.model_classes;

public class Pair_of_words_Model {
    public Pair_of_words_Model(String heading, String meaning, String synonyoms, String defination, int image) {
        Heading = heading;
        Meaning = meaning;
        Synonyoms = synonyoms;
        Defination = defination;
        Image = image;
    }

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

    public String getSynonyoms() {
        return Synonyoms;
    }

    public void setSynonyoms(String synonyoms) {
        Synonyoms = synonyoms;
    }

    public String getDefination() {
        return Defination;
    }

    public void setDefination(String defination) {
        Defination = defination;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    private String Heading,Meaning,Synonyoms,Defination;
    private int Image;
}
