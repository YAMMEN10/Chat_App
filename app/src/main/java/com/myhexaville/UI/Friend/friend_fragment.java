package com.myhexaville.UI.Friend;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myhexaville.Logic.Friend.$_FriendInfo;
import com.myhexaville.UI.Adapter.AdapterFriend.$_Recycle_View_Friend_Adapter;
import com.myhexaville.UI.Adapter.AdapterFriend.$_Value_Item_Friend;
import com.myhexaville.UI.ToolStorage.FriendPathMangment;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

import java.io.File;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link friend_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link friend_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class friend_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private $_Recycle_View_Friend_Adapter recycleViewFriend;
    private ArrayList<$_Value_Item_Friend> valueItemFriends;
    private RecyclerView recyclerView;

    public $_Recycle_View_Friend_Adapter getRecycleViewFriend() {
        return recycleViewFriend;
    }

    public void setRecycleViewFriend($_Recycle_View_Friend_Adapter recycleViewFriend) {
        this.recycleViewFriend = recycleViewFriend;
    }

    public ArrayList<$_Value_Item_Friend> getValueItemFriends() {
        return valueItemFriends;
    }

    public void setValueItemFriends(ArrayList<$_Value_Item_Friend> valueItemFriends) {
        this.valueItemFriends = valueItemFriends;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    public OnFragmentInteractionListener getmListener() {
        return mListener;
    }

    public void setmListener(OnFragmentInteractionListener mListener) {
        this.mListener = mListener;
    }

    private OnFragmentInteractionListener mListener;

    public friend_fragment() {
        // Required empty public constructor
        valueItemFriends=new ArrayList<>();
        recycleViewFriend=new $_Recycle_View_Friend_Adapter(getContext(),valueItemFriends);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment friend_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static friend_fragment newInstance(String param1, String param2) {
        friend_fragment fragment = new friend_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_friend_fragment, container, false);
       add_friends_from_files(FriendPathMangment.FriendPath + "/");
        recyclerView=view.findViewById(R.id.list_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(recycleViewFriend);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public void add_friends_from_files(String path)
    {
        File all_friend = new File(path);
        $_FriendInfo friendInfo;

        for (File temp_file : all_friend.listFiles())
        {
            friendInfo = ($_FriendInfo) MainActivity.store_friend.retriveFriend(temp_file.getName());
            $_Value_Item_Friend valueItemFriend=new $_Value_Item_Friend(friendInfo.getId(),friendInfo.getUser(),friendInfo.getState(),friendInfo.getPhoto());
            valueItemFriends.add(valueItemFriend);

        }
        recycleViewFriend.notifyDataSetChanged();


    }

    public void remove(String id_user) {

        for (int i = 0; i <valueItemFriends.size() ; i++) {
            if(valueItemFriends.get(i).getId().equals(id_user))
            {
                valueItemFriends.remove(valueItemFriends.get(i));
            }
            
        }
        recycleViewFriend.notifyDataSetChanged();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
