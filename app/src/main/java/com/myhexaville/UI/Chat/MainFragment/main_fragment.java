package com.myhexaville.UI.Chat.MainFragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.myhexaville.UI.Adapter.AdapterPageViewer.$_Page_Adapter;
import com.myhexaville.login.R;
import com.myhexaville.login.SecondActivity;
import com.myhexaville.login.ThirdActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link main_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link main_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class main_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // Attribute
    ViewPager viewPager;
    PagerTabStrip pagerTabStrip;
    $_Page_Adapter page_adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public main_fragment() {
        // Required empty public constructor
        page_adapter = new $_Page_Adapter(SecondActivity.fragmentManager);

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment main_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static main_fragment newInstance(String param1, String param2) {
        main_fragment fragment = new main_fragment();
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
        View view = inflater.inflate(R.layout.fragment_main_fragment, container, false);
        //Setting For Drawer
        viewPager = view.findViewById(R.id.viewPager);
        pagerTabStrip = view.findViewById(R.id.tapPager);
        pagerTabStrip.setTabIndicatorColor(Color.WHITE);
        pagerTabStrip.setTextColor(Color.WHITE);
        pagerTabStrip.setTextSize(1, 20);
        viewPager.setAdapter(page_adapter);
        setHasOptionsMenu(true);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String json, String id) {
        if (mListener != null) {
            mListener.onFragmentInteraction(json, id);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_search_open) {
          /*  FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            search_fragment search_fragment = new search_fragment();
            MainActivity.fragment_search = search_fragment;
            fragmentTransaction.add(R.id.container_main_second, search_fragment).addToBackStack(null).hide(search_fragment).show(search_fragment).commit();
            //fragmentTransaction.add(R.id.container_main_second, search_fragment).addToBackStack(null).hide(search_fragment).addToBackStack(null).commit();
*/
            Bundle bundle = new Bundle();
            bundle.putString("fragment", "search_fragment");
            Intent intent = new Intent(getContext(), ThirdActivity.class);
            intent.putExtras(bundle);
            getActivity().startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String json, String id);
    }
}
