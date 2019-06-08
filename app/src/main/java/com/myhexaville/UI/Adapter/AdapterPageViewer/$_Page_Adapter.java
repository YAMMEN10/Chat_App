package com.myhexaville.UI.Adapter.AdapterPageViewer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myhexaville.UI.Chat.MainFragment.MainChat.main_chat_fragment;
import com.myhexaville.UI.Friend.OnlineFriendFragment;
import com.myhexaville.UI.Friend.friend_fragment;
import com.myhexaville.UI.Notification.notification_fragment;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.SecondActivity;


public class $_Page_Adapter extends FragmentStatePagerAdapter {
    String[] tittle = {"Home", "Notification","Friend","Online"};
    Fragment[] fragments = new Fragment[tittle.length];

    public $_Page_Adapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        for (int i = 0; i < tittle.length; i++) {
            switch (i) {
                case 0:
                    fragments[i] = new main_chat_fragment();
                    break;
                case 1: {
                    fragments[i] = new notification_fragment();
                    MainActivity.fragment_notifiction = (notification_fragment) fragments[i];
                    break;
                }
                case 2:
                {
                    fragments[i]= SecondActivity.friend_fragment;

                    break;
                }
                case 3:
                {
                    fragments[i]=SecondActivity.onlineFriendFragment;
                    break;
                }

            }
        }
    }


    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tittle[position];
    }
}
