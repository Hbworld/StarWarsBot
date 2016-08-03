package hbworld.com.starwarsbot.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.model.Chat;
import hbworld.com.starwarsbot.model.FilmResponse;
import hbworld.com.starwarsbot.model.Films;
import hbworld.com.starwarsbot.model.People;
import hbworld.com.starwarsbot.model.PeopleResponse;
import hbworld.com.starwarsbot.ui.activity.DetailActivity;
import hbworld.com.starwarsbot.ui.adapter.ChatAdapter;
import hbworld.com.starwarsbot.utils.ChatUtil;
import hbworld.com.starwarsbot.utils.Constants;
import hbworld.com.starwarsbot.webConnect.ApiClient;
import hbworld.com.starwarsbot.webConnect.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hbworld_new on 8/2/2016.
 */
public class ChatViewModel extends BaseObservable {

    private Context context;
    private Chat chat;
    private static final String TAG = "Chat";
    private ChatAdapter chatAdapter;
    private RecyclerView mRecyclerView;
    private List<Chat> mChats = new ArrayList<>();
    private ArrayList<People> mPeoples = new ArrayList<>();
    private ArrayList<Films> mFilms = new ArrayList<>();
    private static final String INTENT_PEOPLE = "people";
    private static final String INTENT_FILMS = "films";
    private static final String INTENT_TAG = "tag";


    public ChatViewModel(Context context, Chat chat, ChatAdapter chatAdapter, RecyclerView recyclerView, ArrayList<Films> films, ArrayList<People> peoples) {
        this.context = context;
        this.chat = chat;
        this.mFilms = films;
        this.mPeoples = peoples;
        this.chatAdapter = chatAdapter;
        this.mRecyclerView = recyclerView;

    }

    public String getChatMessage() {
        return chat.getMessage();
    }

    public String getChoiceFirst() {
        return chat.getChoice_first();
    }

    public String getChoiceSecond() {
        return chat.getChoice_second();
    }

    public int getChoiceVisibility() {
        return chat.getType().equals(Constants.TYPE_CHAT) ? View.GONE : View.VISIBLE;
    }

    public int getMessageVisibility() {
        return chat.getType().equals(Constants.TYPE_CHAT) ? View.VISIBLE : View.GONE;
    }

    public int getAvatarVisibility() {
        return chat.isFirst() ? View.VISIBLE : View.INVISIBLE;
    }

    public Drawable getImageUrl() {
        int resourceID = chat.isLeft() ? R.mipmap.admin : R.mipmap.user;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(resourceID, context.getApplicationContext().getTheme());
        } else {
            return context.getResources().getDrawable(resourceID);
        }
    }

    public View.OnClickListener onClickChoiceFirst() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ChatUtil chatUtil = new ChatUtil();
                if (chat.getType().equals(Constants.TYPE_CHOICE_TWO)) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    if (chat.isPeople()) {
                        intent.putExtra(INTENT_PEOPLE, mPeoples.get(0));
                    } else intent.putExtra(INTENT_FILMS, mFilms.get(0));

                    intent.putExtra(INTENT_TAG, chat.isPeople());
                    context.startActivity(intent);
                } else {
                    chatUtil.setMessages(false, true, context.getString(R.string.people), Constants.TYPE_CHAT, 0, null, null, mChats, chatAdapter, mRecyclerView);

                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<PeopleResponse> call = apiService.getPeople();
                    call.enqueue(new Callback<PeopleResponse>() {
                        @Override
                        public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {

                            final ArrayList<People> peoples = new ArrayList<People>();
                            for (int i = 0; i <= 2; i++) {
                                peoples.add(response.body().getResults().get(i));
                            }

                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    new ChatUtil().playBlopSound();
                                    Chat chat = new Chat();
                                    mChats.clear();
                                    chat.setLeft(true);
                                    chat.setFirst(true);
                                    chat.setType(Constants.TYPE_CHOICE_TWO);
                                    chat.setChoice_first(peoples.get(0).getName());
                                    chat.setChoice_second(peoples.get(1).getName());
                                    chat.setViewType(1);
                                    chat.setPeople(true);
                                    mChats.add(chat);
                                    chatAdapter.addPeople(peoples);
                                    chatAdapter.addItem(mChats);

                                    if (chatAdapter.getItemCount() > 1) {
                                        mRecyclerView.getLayoutManager().smoothScrollToPosition(mRecyclerView, null, chatAdapter.getItemCount() - 1);
                                    }
                                }
                            }, 2000);
                        }

                        @Override
                        public void onFailure(Call<PeopleResponse> call, Throwable t) {
                            // Log error here since request failed
                            Log.e(TAG, t.toString());
                        }
                    });
                }
            }
        };
    }

    public View.OnClickListener onClickChoiceSecond() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ChatUtil chatUtil = new ChatUtil();
                if (chat.getType().equals(Constants.TYPE_CHOICE_TWO)) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    if (chat.isPeople()) {
                        intent.putExtra(INTENT_PEOPLE, mPeoples.get(1));
                    } else intent.putExtra(INTENT_FILMS, mFilms.get(1));
                    intent.putExtra(INTENT_TAG, chat.isPeople());
                    context.startActivity(intent);
                } else {
                    chatUtil.setMessages(false, true, context.getString(R.string.films), Constants.TYPE_CHAT, 0, null, null, mChats, chatAdapter, mRecyclerView);

                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    Call<FilmResponse> call = apiService.getFilms();
                    call.enqueue(new Callback<FilmResponse>() {
                        @Override
                        public void onResponse(Call<FilmResponse> call, Response<FilmResponse> response) {
                            final ArrayList<Films> films = new ArrayList<Films>();
                            for (int i = 0; i <= 2; i++) {
                                films.add(response.body().getResults().get(i));
                            }
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    new ChatUtil().playBlopSound();
                                    Chat chat = new Chat();
                                    mChats.clear();
                                    chat.setLeft(true);
                                    chat.setFirst(true);
                                    chat.setType(Constants.TYPE_CHOICE_TWO);
                                    chat.setChoice_first(films.get(0).getTitle());
                                    chat.setChoice_second(films.get(1).getTitle());
                                    chat.setViewType(1);
                                    chat.setPeople(false);
                                    mChats.add(chat);
                                    chatAdapter.addItem(mChats);
                                    chatAdapter.addFilms(films);
                                    if (chatAdapter.getItemCount() > 1) {
                                        mRecyclerView.getLayoutManager().smoothScrollToPosition(mRecyclerView, null, chatAdapter.getItemCount() - 1);
                                    }
                                }
                            }, 2000);
                        }

                        @Override
                        public void onFailure(Call<FilmResponse> call, Throwable t) {
                            // Log error here since request failed
                            Log.e(TAG, t.toString());
                        }
                    });
                }
            }
        };
    }

}

