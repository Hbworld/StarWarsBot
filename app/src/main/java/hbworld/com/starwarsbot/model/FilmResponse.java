package hbworld.com.starwarsbot.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hbworld_new on 8/3/2016.
 */
public class FilmResponse {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Films> results = new ArrayList<>();

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The next
     */
    public Object getNext() {
        return next;
    }

    /**
     *
     * @param next
     * The next
     */
    public void setNext(Object next) {
        this.next = next;
    }

    /**
     *
     * @return
     * The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     * The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     * The results
     */
    public List<Films> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Films> results) {
        this.results = results;
    }
}
