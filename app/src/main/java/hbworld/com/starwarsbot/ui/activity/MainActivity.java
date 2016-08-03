package hbworld.com.starwarsbot.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.model.Chat;
import hbworld.com.starwarsbot.ui.adapter.ChatAdapter;
import hbworld.com.starwarsbot.utils.ChatUtil;
import hbworld.com.starwarsbot.utils.Constants;

public class MainActivity extends BaseActivity {

    private RecyclerView mListChat;
    private ChatAdapter mChatAdapter;
    private List<Chat> mChats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureToolbar(getString(R.string.activity_main_title));
        mChats = new ArrayList<>();

        mListChat = (RecyclerView) findViewById(R.id.vertical_recyclerView);
        mChatAdapter = new ChatAdapter(this, mListChat);
        setupRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mChatAdapter.getItemCount() == 0) {
            setInitialMessages();
        } else setResumeState();


    }

    private void setResumeState() {
        final ChatUtil chatUtil = new ChatUtil();
        chatUtil.setMessages(true, true, getString(R.string.bot_text_third), Constants.TYPE_CHAT, 1, null, null, mChats, mChatAdapter, mListChat);
        new Handler().postDelayed(new Runnable() {
            public void run() {

                chatUtil.setMessages(true, false, null, Constants.TYPE_CHOICE, 1, getString(R.string.choice_first), getString(R.string.choice_second), mChats, mChatAdapter, mListChat);
            }
        }, 2000);
    }

    public void setInitialMessages() {
        final int secondsDelayed = 3;

        final ChatUtil chatUtil = new ChatUtil();

        chatUtil.setMessages(true, true, getString(R.string.bot_text_first), Constants.TYPE_CHAT, 1, null, null, mChats, mChatAdapter, mListChat);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                chatUtil.setMessages(true, false, getString(R.string.bot_text_second), Constants.TYPE_CHAT, 1, null, null, mChats, mChatAdapter, mListChat);

                new Handler().postDelayed(new Runnable() {
                    public void run() {

                        chatUtil.setMessages(true, false, getString(R.string.bot_text_third), Constants.TYPE_CHAT, 1, null, null, mChats, mChatAdapter, mListChat);

                        new Handler().postDelayed(new Runnable() {
                            public void run() {

                                chatUtil.setMessages(true, false, null, Constants.TYPE_CHOICE, 1, getString(R.string.choice_first), getString(R.string.choice_second), mChats, mChatAdapter, mListChat);
                            }
                        }, 2000);
                    }
                }, secondsDelayed * 1000);
            }
        }, secondsDelayed * 1000);
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mListChat.setLayoutManager(linearLayoutManager);
        mListChat.setHasFixedSize(true);
        mListChat.setAdapter(mChatAdapter);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }
}
