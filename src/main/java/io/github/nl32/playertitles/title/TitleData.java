package io.github.nl32.playertitles.title;

public class TitleData {
    String title;
    String item;
    public TitleData(String unparsedTitle, String itemref) {
        this.title = unparsedTitle;
        this.item = itemref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
