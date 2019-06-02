package com.myhexaville.UI.Notification;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.myhexaville.login.R;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.MyViewHolder> {
    private Context context;
    private List<Notification_Item> cartList;

    public CartListAdapter(Context context, List<Notification_Item> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Notification_Item notificationItem = cartList.get(position);
        holder.name.setText(notificationItem.getName());
        holder.description.setText(notificationItem.getDescription());
        holder.thumbnail.setImageResource(R.drawable.user);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public void removeItem(int position) {
        cartList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Notification_Item notificationItem, int position) {
        cartList.add(position, notificationItem);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        public ImageView thumbnail;
        public ConstraintLayout viewBackground, viewForeground;
        public Button button;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);

            thumbnail = view.findViewById(R.id.thumbnail);
            viewBackground = view.findViewById(R.id.view_background);
            viewForeground = view.findViewById(R.id.view_foreground);
        }
    }
}
