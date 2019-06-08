package com.myhexaville.UI.Adapter.AdapterOnline;

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

public class $_Recycle_View_Online_Aadpter extends RecyclerView.Adapter<$_Recycle_View_Online_Aadpter.HolderFriendOnline> {


    private ArrayList<$_Value_Item_Online_Friend>  valueItemOnlineFriends;
    private ArrayList<HolderFriendOnline>  holderFriends;
    private Context context;
    public $_Recycle_View_Online_Aadpter(Context context, ArrayList<$_Value_Item_Online_Friend> valueItemOnlineFriends) {
        this.valueItemOnlineFriends = valueItemOnlineFriends;
        this.context=context;
        holderFriends=new ArrayList<>();
    }

    public ArrayList<$_Value_Item_Online_Friend> getValueItemOnlineFriends() {
        return valueItemOnlineFriends;
    }

    public void setValueItemOnlineFriends(ArrayList<$_Value_Item_Online_Friend> valueItemOnlineFriends) {
        this.valueItemOnlineFriends = valueItemOnlineFriends;
    }

    public ArrayList<HolderFriendOnline> getHolderFriends() {
        return holderFriends;
    }

    public void setHolderFriends(ArrayList<HolderFriendOnline> holderFriends) {
        this.holderFriends = holderFriends;
    }

    @NonNull
    @Override
    public HolderFriendOnline onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.onlineitem,viewGroup,false);

        return new HolderFriendOnline(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFriendOnline holderFriendOnline, int i) {
        $_Value_Item_Online_Friend valueItemFriend=valueItemOnlineFriends.get(i);
        holderFriendOnline.itemOnlineFriend.getFriendName().setText(valueItemFriend.getFriendName());
        holderFriendOnline.itemOnlineFriend.getOnline().setText(valueItemFriend.getOnline());

       /* if(holderFriendOnline.itemOnlineFriend.getImageFriend()!=null)
        {
            Glide.with(SecondActivity.fragmentActivity)
                    .load(valueItemFriend.getImage())
                    .asBitmap()
                    .into(
                            holderFriendOnline.itemOnlineFriend.getImageFriend()
                    );}*/
        holderFriends.add(holderFriendOnline);
    }

    @Override
    public int getItemCount() {
        return valueItemOnlineFriends.size();
    }

    public class HolderFriendOnline extends RecyclerView.ViewHolder{
        $_Item_Online_Friend itemOnlineFriend;
        public HolderFriendOnline(@NonNull View itemView) {
            super(itemView);
            itemOnlineFriend=new $_Item_Online_Friend(itemView);
        }
    }
}
