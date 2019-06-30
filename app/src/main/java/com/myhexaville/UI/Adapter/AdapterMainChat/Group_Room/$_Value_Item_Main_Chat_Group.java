package com.myhexaville.UI.Adapter.AdapterMainChat.Group_Room;

import com.myhexaville.Logic.Information.$_AccountInformation;
import com.myhexaville.Logic.Information.$_GroupInformation;
import com.myhexaville.UI.Adapter.AdapterMainChat.$_Abstruct_Value_Item_Main_Chat;

import java.util.List;

public class $_Value_Item_Main_Chat_Group extends $_Abstruct_Value_Item_Main_Chat {
    private List<String> emails;
    private $_GroupInformation groupInformation;
    private List<$_AccountInformation> accountInformations;

    public $_Value_Item_Main_Chat_Group(String message, String name, String email, byte[] image, String type, List<String> emails, $_GroupInformation groupInformation, List<$_AccountInformation> accountInformations) {
        this.message = message;
        this.name = name;
        this.email = email;
        this.image = image;
        this.emails = emails;
        this.type = type;
        this.groupInformation = groupInformation;
        this.accountInformations = accountInformations;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public $_GroupInformation getGroupInformation() {
        return groupInformation;
    }

    public void setGroupInformation($_GroupInformation groupInformation) {
        this.groupInformation = groupInformation;
    }

    public List<$_AccountInformation> getAccountInformations() {
        return accountInformations;
    }

    public void setAccountInformations(List<$_AccountInformation> accountInformations) {
        this.accountInformations = accountInformations;
    }
}
