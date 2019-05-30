package com.cognitive.englishmaster.model_classes;

public class VocabularyDetail
{
    private int icon;
    private String title, definition, example;

    public VocabularyDetail() {
    }

    public VocabularyDetail(int icon, String title, String definition, String example) {
        this.icon = icon;
        this.title = title;
        this.definition = definition;
        this.example = example;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "VocabularyDetail{" +
                "icon=" + icon +
                ", title='" + title + '\'' +
                ", definition='" + definition + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
