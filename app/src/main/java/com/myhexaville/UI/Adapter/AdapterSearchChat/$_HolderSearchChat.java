package com.myhexaville.UI.Adapter.AdapterSearchChat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myhexaville.login.R;

public class $_HolderSearchChat extends RecyclerView.ViewHolder {
    private $_Item_Search_Friend item_search_friend;

    public $_HolderSearchChat(@NonNull View itemView) {
        super(itemView);
        item_search_friend = new $_Item_Search_Friend();
        item_search_friend.setAdd_button(itemView.findViewById(R.id.Add_friend));
        item_search_friend.setAdd_button2(itemView.findViewById(R.id.Add_friend2));
        item_search_friend.setTvName(itemView.findViewById(R.id.tvName));
        item_search_friend.setTvHome(itemView.findViewById(R.id.tvHome));
        item_search_friend.setImageView(itemView.findViewById(R.id.imUser));


    }

    public $_Item_Search_Friend getItem_search_friend() {
        return item_search_friend;
    }

    public void setItem_search_friend($_Item_Search_Friend item_search_friend) {
        this.item_search_friend = item_search_friend;
    }
}
