package com.myhexaville.UI.Adapter.AdapterFriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;
import com.myhexaville.login.ThirdActivity;

import java.util.ArrayList;

public class $_Recycle_View_Friend_Adapter extends RecyclerView.Adapter<$_Recycle_View_Friend_Adapter.HolderFriend>{

    private Context context;
    private ArrayList<HolderFriend> Holder_friends;
    private  ArrayList<$_Value_Item_Friend> valueItemFriends;
    public $_Recycle_View_Friend_Adapter(Context context, ArrayList<$_Value_Item_Friend> valueItemFriends) {
        this.context = context;
        this.valueItemFriends=valueItemFriends;
        Holder_friends=new ArrayList<>();
    }

    @NonNull
    @Override
    public HolderFriend onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frienditem,viewGroup,false);

        return new HolderFriend(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFriend holderFriend, int i) {
        $_Value_Item_Friend valueItemFriend=valueItemFriends.get(i);
        holderFriend.item_friend.getUser_Name().setText(valueItemFriend.getUser_Name());
        holderFriend.item_friend.getState().setText(valueItemFriend.getState());

     /*   if(valueItemFriend.getImage()!=null)
        {Glide.with(SecondActivity.fragmentActivity)
                .load(valueItemFriend.getImage())
                .asBitmap()
                .into(
                       holderFriend.item_friend.getImage()
                );}*/
        Holder_friends.add(holderFriend);
    }

    @Override
    public int getItemCount() {
        return valueItemFriends.size();
    }

    public class HolderFriend extends RecyclerView.ViewHolder{
        $_Item_Friend item_friend;


        public HolderFriend(@NonNull View itemView) {
            super(itemView);
            item_friend=new $_Item_Friend(itemView);
        }
    }
}
