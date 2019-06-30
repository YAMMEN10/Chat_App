package com.myhexaville.UI.Adapter.AdapterCreateGroup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bumptech.glide.Glide;
import com.myhexaville.login.FiveActivity;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;

import java.util.ArrayList;

public class $_Recycle_View_Create_Group_Adapter extends RecyclerView.Adapter<$_Recycle_View_Create_Group_Adapter.HolderFriend> {

    private Context context;
    private ArrayList<HolderFriend> Holder_friends;
    private ArrayList<$_Value_Item_Create_Group> value_item_create_groups;

    public $_Recycle_View_Create_Group_Adapter(Context context, ArrayList<$_Value_Item_Create_Group> value_item_create_groups) {
        this.context = context;
        this.value_item_create_groups = value_item_create_groups;
        Holder_friends = new ArrayList<>();
    }

    @NonNull
    @Override
    public HolderFriend onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_create_group, viewGroup, false);

        return new HolderFriend(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFriend holderFriend, int i) {
        $_Value_Item_Create_Group value_item_create_group = value_item_create_groups.get(i);
        holderFriend.item_create_group.getUser_Name().setText(value_item_create_group.getUser_Name());
        holderFriend.item_create_group.getState().setText(value_item_create_group.getState());

        Glide.with(SecondActivity.fragmentActivity)
                .load(value_item_create_group.getImage())
                .asBitmap()
                .into(
                        holderFriend.item_create_group.getImage()
                );
        Holder_friends.add(holderFriend);
        if (value_item_create_group.isSelected()) {
            holderFriend.item_create_group.getCheckBox().setChecked(true);
        } else holderFriend.item_create_group.getCheckBox().setChecked(false);
    }

    @Override
    public int getItemCount() {
        return value_item_create_groups.size();
    }


    public class HolderFriend extends RecyclerView.ViewHolder {
        $_Item_Create_Group item_create_group;


        public HolderFriend(@NonNull View itemView) {
            super(itemView);
            item_create_group = new $_Item_Create_Group(itemView);
            initAction();
        }

        private void initAction() {
            item_create_group.getCheckBox().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        FiveActivity.selected_item.add(FiveActivity.value_item_create_groups.get(getAdapterPosition()));
                    } else {
                        if (FiveActivity.selected_item.size() > 0)
                            FiveActivity.selected_item.remove(getAdapterPosition());

                    }
                }
            });
        }
    }
}
