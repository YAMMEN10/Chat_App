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
import com.myhexaville.UI.Adapter.AdapterFriend.$_Value_Item_Friend;
import com.myhexaville.UI.Adapter.AdapterOnline.$_Recycle_View_Online_Aadpter;
import com.myhexaville.UI.Adapter.AdapterOnline.$_Value_Item_Online_Friend;
import com.myhexaville.login.MainActivity;
import com.myhexaville.login.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnlineFriendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OnlineFriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OnlineFriendFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private $_Recycle_View_Online_Aadpter viewOnlineAadpter;
    private ArrayList<$_Value_Item_Online_Friend> valueItemOnlineFriends;
    private RecyclerView recyclerView;

    private OnFragmentInteractionListener mListener;

    public OnlineFriendFragment() {
        // Required empty public constructor
        valueItemOnlineFriends=new ArrayList<>();


    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OnlineFriendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OnlineFriendFragment newInstance(String param1, String param2) {
        OnlineFriendFragment fragment = new OnlineFriendFragment();
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
        View view= inflater.inflate(R.layout.online_friendfragment, container, false);

        viewOnlineAadpter=new $_Recycle_View_Online_Aadpter(getContext(),valueItemOnlineFriends);
        recyclerView=view.findViewById(R.id.list_online);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(viewOnlineAadpter);



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

    public void add_Online(ArrayList<String> Ids,ArrayList<String> Online)
    {
        valueItemOnlineFriends.clear();
        for (int i = 0; i < Ids.size(); i++) {
            if(Online.get(i).equals("Online"))
            {
               $_FriendInfo friendInfo = ($_FriendInfo) MainActivity.store_friend.retriveFriend(Ids.get(i));
               valueItemOnlineFriends.add(new $_Value_Item_Online_Friend(friendInfo.getId(),friendInfo.getUser(),"Online",friendInfo.getPhoto()));
                System.out.println("totototototo");
            }
        }
        viewOnlineAadpter.notifyDataSetChanged();


    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
