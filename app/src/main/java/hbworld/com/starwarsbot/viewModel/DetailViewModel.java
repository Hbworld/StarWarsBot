package hbworld.com.starwarsbot.viewModel;

import android.app.Activity;
import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import hbworld.com.starwarsbot.model.Films;
import hbworld.com.starwarsbot.model.People;
import hbworld.com.starwarsbot.utils.AppUtil;

/**
 * Created by Hbworld_new on 8/3/2016.
 */
public class DetailViewModel extends BaseObservable {
    private Context context;
    private boolean isPeople;
    private People people;
    private Films films;

    public DetailViewModel(Context context, People people, Films films, boolean isPeople) {
        this.context = context;
        this.people = people;
        this.films = films;
        this.isPeople = isPeople;

    }

    public String getName() {
        return isPeople ? people.getName() : films.getTitle();
    }

    public String getUrl() {
        return isPeople ? people.getUrl() : films.getUrl();
    }

    public String getCreatedOn() {
        return new AppUtil().getDate(isPeople ? people.getCreated() : films.getCreated());
    }

    public View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) context).finish();
            }
        };
    }
}
