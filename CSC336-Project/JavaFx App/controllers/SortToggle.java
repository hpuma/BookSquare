package controllers;

public class SortToggle {

    private int price;
    private int condition;
    private int time;

    public SortToggle(int p, int c, int t){
        this.price = p;
        this.condition = c;
        this.time = t;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
