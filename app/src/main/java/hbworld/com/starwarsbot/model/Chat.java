package hbworld.com.starwarsbot.model;

/**
 * Created by Hbworld_new on 8/2/2016.
 */
public class Chat {

    private String message;
    private boolean left;
    private String type;
    private boolean first;
    private String choice_first;
    private String choice_second;
    private int viewType;
    private boolean people;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChoice_first() {
        return choice_first;
    }

    public void setChoice_first(String choice_first) {
        this.choice_first = choice_first;
    }

    public String getChoice_second() {
        return choice_second;
    }

    public void setChoice_second(String choice_second) {
        this.choice_second = choice_second;
    }

    public boolean isPeople() {
        return people;
    }

    public void setPeople(boolean people) {
        this.people = people;
    }
}
