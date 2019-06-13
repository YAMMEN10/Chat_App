package com.myhexaville.UI.Chat.SearchFragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.myhexaville.UI.Adapter.AdapterSearchChat.$_HolderSearchChat;
import com.myhexaville.login.R;
import com.myhexaville.login.ThirdActivity;

import java.util.ArrayList;

public class User_Adapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<User_Info_Search> user_info_searches;
    private ArrayList<$_HolderSearchChat> holderSearchChats;

    public User_Adapter(Context context, ArrayList<User_Info_Search> users) {
        this.context = context;
        this.user_info_searches = users;
        holderSearchChats = new ArrayList<>();
    }

    public ArrayList<$_HolderSearchChat> getHolderSearchChats() {
        return holderSearchChats;
    }

    public void setHolderSearchChats(ArrayList<$_HolderSearchChat> holderSearchChats) {
        this.holderSearchChats = holderSearchChats;
    }

    @NonNull
    @Override
    public $_HolderSearchChat onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_view, viewGroup, false);

        return new $_HolderSearchChat(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder $_holderSearchChat, int i) {
        final User_Info_Search userInfoSearch = user_info_searches.get(i);
        holderSearchChats.add(($_HolderSearchChat) $_holderSearchChat);
        holderSearchChats.get(i).getItem_search_friend().getTvHome().setText(userInfoSearch.getmDescription());
        holderSearchChats.get(i).getItem_search_friend().getTvName().setText(userInfoSearch.getmTitle());
        holderSearchChats.get(i).getItem_search_friend().getAdd_button().setText(userInfoSearch.getButton_text());
        if (userInfoSearch.getButton_text().equals("Refusal")) {
            holderSearchChats.get(i).getItem_search_friend().getAdd_button2().setText("Accept");
            holderSearchChats.get(i).getItem_search_friend().getAdd_button2().setVisibility(View.VISIBLE);
        }
        holderSearchChats.get(i).getItem_search_friend().getAdd_button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity.search_fragment.set_action(userInfoSearch.getButton_text(), userInfoSearch.getId(), userInfoSearch.getmTitle(), userInfoSearch.getmImageUrl());
            }
        });
        holderSearchChats.get(i).getItem_search_friend().getAdd_button2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity.search_fragment.set_action("Accept", userInfoSearch.getId(), userInfoSearch.getmTitle(), userInfoSearch.getmImageUrl());

            }
        });
       if(userInfoSearch.getmImageUrl()!=null) Glide.with(ThirdActivity.fragmentActivity)
                .load(userInfoSearch.getmImageUrl())
                .asBitmap()
                .into(
                        holderSearchChats.get(i).getItem_search_friend().getImageView()
                );
    }

    @Override
    public int getItemCount() {
        return user_info_searches.size();
    }


    public ArrayList<User_Info_Search> getUser_info_searches() {
        return user_info_searches;
    }

    public void setUser_info_searches(ArrayList<User_Info_Search> user_info_searches) {
        this.user_info_searches = user_info_searches;
    }


}
