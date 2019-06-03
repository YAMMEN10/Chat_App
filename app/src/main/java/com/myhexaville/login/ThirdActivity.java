package com.myhexaville.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.myhexaville.UI.Chat.SearchFragment.search_fragment;


public class ThirdActivity extends AppCompatActivity implements search_fragment.OnFragmentInteractionListener {

    public static FragmentManager fragmentManager;
    public static FragmentActivity fragmentActivity;
    public static Context context;
    public static com.myhexaville.UI.Chat.SearchFragment.search_fragment search_fragment;//Fragment
    private static FragmentTransaction fragmentTransaction;


    public ThirdActivity() {
        fragmentActivity = this;
        context = this;
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        search_fragment = new search_fragment();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        String fragment = getIntent().getExtras().getString("fragment");

        if (findViewById(R.id.container_main_third) != null) {
            if (savedInstanceState != null) return;
            if (fragment.equals("search_fragment")) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container_main_third, ThirdActivity.search_fragment).commit();
            }
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
