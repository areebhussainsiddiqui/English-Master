package com.cognitive.englishmaster.model_classes;

public class Blog
{
    private int img;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String  image;
    private String title;

    public Blog(int img, String title) {
        this.img = img;
        this.title = title;
    }
    public Blog(String img, String title) {
        this.image = img;
        this.title = title;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
