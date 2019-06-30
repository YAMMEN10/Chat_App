package com.myhexaville.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.allattentionhere.fabulousfilter.AAH_FabulousFragment;
import com.myhexaville.UI.Account.signup_fragment_tow;
import com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment;
import com.myhexaville.UI.Chat.MainFragment.RoomChat.room_chat;
import com.myhexaville.UI.Chat.MainFragment.main_fragment;
import com.myhexaville.UI.Chat.SearchFragment.search_fragment;
import com.myhexaville.UI.Friend.OnlineFriendFragment;
import com.myhexaville.UI.Friend.friend_fragment;
import com.myhexaville.UI.MySampleFabFragment;
import com.myhexaville.UI.Notification.notification_fragment;

public class SecondActivity extends AppCompatActivity implements main_fragment.OnFragmentInteractionListener,
        main_chat_fragment.OnFragmentInteractionListener,
        notification_fragment.OnFragmentInteractionListener,
        room_chat.OnFragmentInteractionListener,
        signup_fragment_tow.OnFragmentInteractionListener,
        search_fragment.OnFragmentInteractionListener,
        friend_fragment.OnFragmentInteractionListener,
        OnlineFriendFragment.OnFragmentInteractionListener,
        AAH_FabulousFragment.Callbacks,
        AAH_FabulousFragment.AnimationListener {

    public static FragmentManager fragmentManager;
    public static FragmentActivity fragmentActivity;
    public static Context context;
    //Fragment
    public static main_fragment main_fragment;
    public static signup_fragment_tow signup_fragment_tow;
    private FloatingActionButton fab;
    private static FragmentTransaction fragmentTransaction;
    public static friend_fragment friend_fragment;
    public static OnlineFriendFragment onlineFriendFragment;

    // Attribute


    public SecondActivity() {
        fragmentActivity = this;
        context = this;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        main_fragment = new main_fragment();
        signup_fragment_tow = new signup_fragment_tow();

        // init All Fragment
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*fragmentActivity = this;
        context = this;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();*/

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySampleFabFragment dialogFrag = MySampleFabFragment.newInstance();
                dialogFrag.setParentFab(fab);
                dialogFrag.show(getSupportFragmentManager(), dialogFrag.getTag());
            }
        });
        if (findViewById(R.id.container_main_second) != null) {
            if (savedInstanceState != null) return;
            fragmentTransaction = fragmentManager.beginTransaction();
            if (getIntent() == null) {
            }
            if (getIntent().getExtras().getString("fragment").equals("main_fragment")) {
            /*Bundle bundle = new Bundle();
            bundle.putString("data", finalMy_json.toString());
            main_fragment.setArguments(bundle);
            main_fragment.setArguments(bundle);*/

                fragmentTransaction.replace(R.id.container_main_second, main_fragment).addToBackStack(null).commit();
            } else if (getIntent().getExtras().getString("fragment").equals("signup_fragment_tow")) {
            /*Bundle bundle = new Bundle();
            bundle.putString("data", finalMy_json.toString());
            main_fragment.setArguments(bundle);
            main_fragment.setArguments(bundle);*/
                fragmentTransaction.replace(R.id.container_main_second, signup_fragment_tow).commit();
            }


        }

    }

    @Override
    public void onFragmentInteraction(String json, String id) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }


    @Override
    public void onResult(Object result) {
        Log.d("k9res", "onResult: " + result.toString());

        if (result.toString().equalsIgnoreCase("swiped_down")) {
            //do something or nothing
        } else {
            //handle result

        }
    }

    @Override
    public void onOpenAnimationStart() {
    }

    @Override
    public void onOpenAnimationEnd() {

    }

    @Override
    public void onCloseAnimationStart() {

    }

    @Override
    public void onCloseAnimationEnd() {

    }


}
