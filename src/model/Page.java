package model;

import model.user.User;

import java.util.ArrayList;

public class Page {
    //1 variables
    private String title;
    private String description;
    private ArrayList<User> followersUsers = new ArrayList<User>();
    private ArrayList<Post> postsInPage = new ArrayList<Post>();

    //2 get set

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<User> getFollowersUsers() {
        return followersUsers;
    }

    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }

    public void setTitle(String title) {
        if(title != null && title.length() > 5 && title.length() < 50)
        {this.title = title;}

    }

    public void setDescription(String description) {
        if(description != null && description.length() > 1 && description.length() < 250)
        {this.description = description;}

    }

    //3 constructors
    public Page() {
        setTitle("Title of page");
        setDescription("Placeholder description");
    }

    public Page(String title, String description) {
        setTitle(title);
        setDescription(description);
    }

    //4 tostring
    public String toString() {
        return title + " | " + description + " ( " + followersUsers.size() + "followers | " +postsInPage.size()+ " ) ";
    }


    //5 other
}
