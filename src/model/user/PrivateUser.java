package model.user;

import model.Post;
import model.PostType;

import java.util.ArrayList;

public class PrivateUser extends User{
    //1variables
    private ArrayList<Post> privatePosts = new ArrayList<Post>();
    private ArrayList<Post> publicPosts = new ArrayList<Post>();
    private ArrayList<User> followers = new ArrayList<User>();

    //2get set

    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }

    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    @Override
    public void setNameAndSurnameOrTitle(String nameAndSurnameOrTitle) {

        if(nameAndSurnameOrTitle != null && nameAndSurnameOrTitle.matches("[A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]+ [A-ZĒŪĪĻĶĢŠĀČŅ]{1}[a-zēūīļķģšāžčņ]")){
            super.nameAndSurnameOrTitle = nameAndSurnameOrTitle;
        }else
        {super.nameAndSurnameOrTitle = "------";}

    }
    //3constructors

    public PrivateUser(){
        super(); //izsauc User()- jaizsauc pats pirmais
        setNameAndSurnameOrTitle("Janis Berzins");
        setUsername();
    }

    public PrivateUser(String name, String surname, String password){
        super(password);
        setNameAndSurnameOrTitle(name+ " " +surname);
        setUsername();
    }

    //4tostring
    public String toString(){
        return super.toString() + super.nameAndSurnameOrTitle + "( " + getUsername() + " )";
    }

    //5other

    @Override
    public void publishPost(PostType type, String message)throws Exception{
        //parbaude not null
        if(type == null || message == null){
            throw new Exception ("Bad parameters");
        }
        //izveido post objektu
        Post newPost = new Post(message);

        //ja type ir private ieliek zem privatePosts
        if(type.equals(PostType.PRIVATE)) privatePosts.add(newPost);
        //ja type ip public ieliek zem publicPosts
        if(type.equals(PostType.PUBLIC)) publicPosts.add(newPost);
    }

    public void followPrivateUser(User user) throws Exception{
        //parbauda vai nav null
        if(user == null){throw new Exception("User is not real");}

        //parbauda vai user jau nav sekotaju saraksta
        for(User follower : followers){
            if(user.getUsername().equals(follower.getUsername()))
                throw new Exception("Already following");
        }
        //ja nav tad pievieno
        followers.add(user);
    }

}
