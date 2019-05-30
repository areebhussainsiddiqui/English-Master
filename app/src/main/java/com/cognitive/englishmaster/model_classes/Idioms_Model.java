package com.cognitive.englishmaster.model_classes;

public class Idioms_Model {
    public Idioms_Model(String idiomTitle, String idiomSentence, String idiomsTranslation) {
        IdiomTitle = idiomTitle;
        IdiomSentence = idiomSentence;
        IdiomsTranslation = idiomsTranslation;
    }

    private String IdiomTitle;
    private String IdiomSentence;
    private String IdiomsTranslation;

    public String getIdiomTitle() {
        return IdiomTitle;
    }

    public void setIdiomTitle(String idiomTitle) {
        IdiomTitle = idiomTitle;
    }

    public String getIdiomSentence() {
        return IdiomSentence;
    }

    public void setIdiomSentence(String idiomSentence) {
        IdiomSentence = idiomSentence;
    }

    public String getIdiomsTranslation() {
        return IdiomsTranslation;
    }

    public void setIdiomsTranslation(String idiomsTranslation) {
        IdiomsTranslation = idiomsTranslation;
    }
}
