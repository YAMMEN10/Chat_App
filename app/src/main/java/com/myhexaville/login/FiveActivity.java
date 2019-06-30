package com.myhexaville.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.myhexaville.Logic.Client.$_ClientStatic;
import com.myhexaville.Logic.Information.$_AccountInformation;
import com.myhexaville.Logic.Information.$_AccountInformationById;
import com.myhexaville.Logic.Information.$_GroupInformation;
import com.myhexaville.Logic.JSONData.$_JSONAttributes;
import com.myhexaville.Logic.JSONData.$_JSON_Create_Group;
import com.myhexaville.Logic.Room.$_Group;
import com.myhexaville.Logic.ServerManagment.$_SendData;
import com.myhexaville.UI.$_Static_Class;
import com.myhexaville.UI.Adapter.AdapterCreateGroup.$_Recycle_View_Create_Group_Adapter;
import com.myhexaville.UI.Adapter.AdapterCreateGroup.$_Value_Item_Create_Group;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FiveActivity extends AppCompatActivity {
    public static $_Recycle_View_Create_Group_Adapter recycle_view_create_group_adapter;
    public static ArrayList<$_Value_Item_Create_Group> value_item_create_groups;
    public static List<$_Value_Item_Create_Group> selected_item;

    private RecyclerView list_create_group;

    public FiveActivity(int i) {
        value_item_create_groups = new ArrayList<>();
        recycle_view_create_group_adapter = new $_Recycle_View_Create_Group_Adapter(getBaseContext(), value_item_create_groups);
    }

    public FiveActivity() {
        //nothing -_-
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        selected_item = new ArrayList<>();
        list_create_group = findViewById(R.id.list_create_group);
        list_create_group.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        list_create_group.setAdapter(recycle_view_create_group_adapter);
        recycle_view_create_group_adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.group_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getTitle().toString()) {
            case "Edit Profile": {

                break;
            }
            case "Create Group": {
                $_GroupInformation groupInformation = new $_GroupInformation("state", new byte[10], "name", $_Static_Class.getCurrentDate(), "usename");


                List<$_AccountInformation> clients = new ArrayList<>();
                $_AccountInformation accountInformation = new $_AccountInformationById($_ClientStatic.getEmail(),
                        $_ClientStatic.getState(),
                        $_ClientStatic.getPersonalImage(),
                        $_ClientStatic.getUserName(),
                        "*****"
                );
                clients.add(accountInformation);
                for (int i = 0; i < selected_item.size(); i++) {
                    System.out.println("IIIIIIIIIIIIIIIIII = " + i);
                    accountInformation = new $_AccountInformationById(selected_item.get(i).getId(),
                            selected_item.get(i).getState(),
                            selected_item.get(i).getImage(),
                            selected_item.get(i).getUser_Name(),
                            "*****"
                    );
                    clients.add(accountInformation);
                }


                $_Group group = new $_Group(groupInformation, clients);
                JSONArray jsonArray = createJSONObject(group);
              /*  try {
                    System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVv = " + jsonArray.getString(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

                    $_JSON_Create_Group json_create_group = new $_JSON_Create_Group(
                            "Create_Group",
                            $_ClientStatic.getEmail(),
                            group.getGroup_information().getID(),
                            group
                    );

                    $_SendData sendData = new $_SendData(json_create_group, "Create_Group");
                    sendData.excute();

                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                $_ClientStatic.getDataOutputStreamMessage().writeUTF(sendData.getJson_object().toString());
                                $_ClientStatic.getDataOutputStreamMessage().write(group.getGroup_information().getPicture());
                                for (int i = 0; i < group.getClients().size(); i++) {
                                    $_ClientStatic.getDataOutputStreamMessage().write(group.getClients().get(i).getPicture());
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }

    private JSONArray createJSONObject($_Group group) {
        // Information Of Group
        JSONArray groups_clients_information_for_one = new JSONArray();
        JSONObject item_group_information = new JSONObject();
        try {
            item_group_information.
                    put($_JSONAttributes.User_Name.toString(), group.getGroup_information().getUser_name()).
                    put($_JSONAttributes.State.toString(), group.getGroup_information().getState()).
                    put($_JSONAttributes.IdGroup.toString(), group.getGroup_information().getID()).
                    put($_JSONAttributes.Message.toString(), group.getGroup_information().getPicture().length);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Client for group
        for (int j = 0; j < group.getClients().size(); j++) {
            JSONObject item_client_information = new JSONObject();
            try {
                item_client_information.put($_JSONAttributes.User_Name.toString(), group.getClients().get(j).getUser_name()).
                        put($_JSONAttributes.State.toString(), group.getClients().get(j).getState()).
                        put($_JSONAttributes.Id.toString(), group.getClients().get(j).getID()).
                        put($_JSONAttributes.Password.toString(), group.getClients().get(j).getPassword()).
                        put($_JSONAttributes.Message.toString(), group.getClients().get(j).getPicture().length);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            groups_clients_information_for_one.put(item_client_information.toString());
        }
        JSONArray all_group = new JSONArray();
        all_group.put(item_group_information.toString());
        all_group.put(groups_clients_information_for_one.toString());
        return all_group;
    }
}
