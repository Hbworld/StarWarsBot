package hbworld.com.starwarsbot.utils;

import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import hbworld.com.starwarsbot.AppController;
import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.model.Chat;
import hbworld.com.starwarsbot.ui.adapter.ChatAdapter;

/**
 * Created by Hbworld_new on 8/3/2016.
 */
public class ChatUtil {

    public void setMessages(boolean isLeft, boolean isFirst, String message, String type, int viewType, String choice_first, String choice_second, List<Chat> mChats, ChatAdapter mChatAdapter, RecyclerView recyclerView) {
        playBlopSound();
        Chat chat = new Chat();
        mChats.clear();
        chat.setLeft(isLeft);
        chat.setFirst(isFirst);
        chat.setType(type);
        if (type.equals(Constants.TYPE_CHAT)) {
            chat.setMessage(message);
        } else {
            chat.setChoice_first(choice_first);
            chat.setChoice_second(choice_second);
        }
        chat.setViewType(viewType);
        mChats.add(chat);
        mChatAdapter.addItem(mChats);
        if (mChatAdapter.getItemCount() > 1) {
            recyclerView.getLayoutManager().smoothScrollToPosition(recyclerView, null, mChatAdapter.getItemCount() - 1);
        }
    }

    public void playBlopSound() {
        final MediaPlayer mp = MediaPlayer.create(AppController.getInstance(), R.raw.blop);
        mp.start();
        mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                return false;
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.stop();
                mp.release();
            }
        });
    }
}
