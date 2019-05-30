package com.cognitive.englishmaster.model_classes;

public class Vocabulary
{
    private int icon, numOfWords;
    private String title;

    public Vocabulary(int icon, String title, int numOfWords) {
        this.icon = icon;
        this.title = title;
        this.numOfWords = numOfWords;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfWords() {
        return numOfWords;
    }

    public void setNumOfWords(int numOfWords) {
        this.numOfWords = numOfWords;
    }
}
