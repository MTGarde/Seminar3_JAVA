package model.user;

import model.Page;
import model.PostType;

import java.util.ArrayList;

public class BusinessUser extends User{
    String PVNNo;
    private ArrayList<Page> listOfPages = new ArrayList<Page>();

    //get set


    public String getPVNNo() {
        return PVNNo;
    }

    public void setPVNNo(String PVNNo) {
        if(PVNNo != null && PVNNo.matches("[A-Z]{2}+[0-9]{11}"))
            this.PVNNo = PVNNo;
        else this.PVNNo = "-------------";
    }

    public ArrayList<Page> getListOfPages() {
        return listOfPages;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%*!?]"))
    }
    //constructors
    //toString
    //other


    @Override
    public void publishPost(PostType type, String message) throws Exception {

    }
}
