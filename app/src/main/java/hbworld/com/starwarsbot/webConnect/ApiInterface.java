package hbworld.com.starwarsbot.webConnect;

import hbworld.com.starwarsbot.model.Chat;
import hbworld.com.starwarsbot.model.FilmResponse;
import hbworld.com.starwarsbot.model.People;
import hbworld.com.starwarsbot.model.PeopleResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Hbworld_new on 8/2/2016.
 */
public interface ApiInterface {
    @GET("people/")
    Call<PeopleResponse> getPeople();

    @GET("films/")
    Call<FilmResponse> getFilms();
}
