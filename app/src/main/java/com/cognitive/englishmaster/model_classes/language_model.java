package com.cognitive.englishmaster.model_classes;

public class language_model {
    public language_model(String country_name, int country_Flag) {
        Country_name = country_name;
        Country_Flag = country_Flag;
    }

    private String Country_name;
    private int Country_Flag;

    public String getCountry_name() {
        return Country_name;
    }

    public void setCountry_name(String country_name) {
        Country_name = country_name;
    }

    public int getCountry_Flag() {
        return Country_Flag;
    }

    public void setCountry_Flag(int country_Flag) {
        Country_Flag = country_Flag;
    }
}
