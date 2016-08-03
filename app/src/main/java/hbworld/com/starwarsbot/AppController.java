package hbworld.com.starwarsbot;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import hbworld.com.starwarsbot.utils.TypefaceUtil;

/**
 * Created by Hbworld_new on 8/2/2016.
 */
public class AppController extends Application {

    private Activity activity;
    private Context context;
    private static AppController appController;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    public static AppController getInstance() {
        return appController;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appController = this;

        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/GothamNarrowBook.otf");
    }
}
