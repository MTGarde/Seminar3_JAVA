package model.user;

import model.Page;
import model.Post;
import model.PostType;

import java.util.ArrayList;

public class BusinessUser extends User{
    String PVNNo;
    private ArrayList<Page> listOfPages = new ArrayList<Page>();

    //get set


    public String getPVNNo() {
        return PVNNo;
    }

    //TODO uztaisit algoritmu kas uztaisa pvn
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
        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-Za-z0-9%*!? ]+")){
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        }else super.nameAndSurnameOrTitle = "-------";
    }

    //constructors
    public BusinessUser(){
        super();       //GuestUser();
        setNameAndSurnameOrTitle("Default");  //ari ir user klase bet tas ir abstraktas funkcijas tapes nevar izmantot
        setUsername();
        setPVNNo("LV10000000000");
    }

    public BusinessUser(String title, String password, String pVNNo){
        super(password);
        setNameAndSurnameOrTitle(title);
        setUsername();
        setPVNNo(pVNNo);
    }

    //toString
    public String toString(){
        return super.toString() + " " +PVNNo;
    }

    //others
    public void createPage(String title, String description)throws Exception{
        //TODO ievades parbaude
        for(Page temp : listOfPages){
            if(temp.getTitle().equals(title)){
                throw new Exception("Page already exists");
            }
        }
        Page newPage = new Page(title, description);
        listOfPages.add(newPage);
    }

    public void publishPostInPage(String pageTitle, String msg)throws Exception{
        //TODO parbaudes
        for(Page temp : listOfPages){
            if(temp.getTitle().equals(pageTitle)){
                Post newPost = publishPost(PostType.PUBLIC, msg);
                temp.getPostsInPage().add(newPost);
                return;
            }
        }
        throw new Exception("Page not found");
    }

    @Override
    public Post publishPost(PostType type, String message) throws Exception {
        Post newPost = new Post(message);
        return newPost;
    }
}
