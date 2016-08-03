package hbworld.com.starwarsbot.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.databinding.ItemChatLeftBinding;
import hbworld.com.starwarsbot.databinding.ItemChatRightBinding;
import hbworld.com.starwarsbot.model.Chat;
import hbworld.com.starwarsbot.model.Films;
import hbworld.com.starwarsbot.model.People;
import hbworld.com.starwarsbot.viewModel.ChatViewModel;

/**
 * Created by Hbworld_new on 8/2/2016.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.BindingHolder> {
    private List<Chat> mChats;
    private ArrayList<Films> mFilms;
    private ArrayList<People> mPeoples;
    private Context mContext;
    private RecyclerView mRecyclerView;


    public ChatAdapter(Context context, RecyclerView recyclerView) {
        mContext = context;
        mRecyclerView = recyclerView;
        mChats = new ArrayList<>();
        mFilms = new ArrayList<>();
        mPeoples = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        return mChats.get(position).getViewType();

    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            ItemChatRightBinding viewDataBindingRight = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_chat_right, parent, false);
            return new BindingHolderRight(viewDataBindingRight);
        } else {
            ItemChatLeftBinding viewDataBindingLeft = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_chat_left, parent, false);
            return new BindingHolderLeft(viewDataBindingLeft);
        }
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            BindingHolderRight bindingHolderRight = (BindingHolderRight) holder;
            ItemChatRightBinding chatBinding = bindingHolderRight.binding_right;
            chatBinding.setViewModel(new ChatViewModel(mContext, mChats.get(position), ChatAdapter.this, mRecyclerView, mFilms, mPeoples));
        } else {
            BindingHolderLeft bindingHolderLeft = (BindingHolderLeft) holder;
            ItemChatLeftBinding chatBinding = bindingHolderLeft.binding_left;
            chatBinding.setViewModel(new ChatViewModel(mContext, mChats.get(position), ChatAdapter.this, mRecyclerView, mFilms, mPeoples));
        }

    }

    @Override
    public int getItemCount() {
        return mChats.size();
    }

    public void addItem(List<Chat> chat) {
        mChats.addAll(chat);
        notifyDataSetChanged();
    }

    public void addPeople(ArrayList<People> peoples) {
        mPeoples.addAll(peoples);
        notifyDataSetChanged();
    }

    public void addFilms(ArrayList<Films> films) {
        mFilms.addAll(films);
        notifyDataSetChanged();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        public BindingHolder(View v) {
            super(v);
        }
    }

    public class BindingHolderLeft extends BindingHolder {
        private ItemChatLeftBinding binding_left;

        public BindingHolderLeft(ItemChatLeftBinding binding_left) {
            super(binding_left.rlLayoutChat);
            this.binding_left = binding_left;
        }
    }

    public class BindingHolderRight extends BindingHolder {
        private ItemChatRightBinding binding_right;

        public BindingHolderRight(ItemChatRightBinding binding_right) {
            super(binding_right.rlLayoutChat);
            this.binding_right = binding_right;
        }
    }

}
