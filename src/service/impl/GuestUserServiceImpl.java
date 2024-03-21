package service.impl;

import model.Page;
import model.Post;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;
import model.user.User;
import service.IGuestUserService;
import service.MainService;

import java.util.ArrayList;

public class GuestUserServiceImpl implements IGuestUserService {
    @Override
    public ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception{
        if(nameOrSurnameOrTitle == null || nameOrSurnameOrTitle.length() < 2){
            throw new Exception("get ratio'd");
        }
        ArrayList<User> foundUsers = new ArrayList<User>();
        for(GuestUser temp : MainService.allUsers){
            if(temp instanceof PrivateUser || temp instanceof BusinessUser){
                User user = (User)temp;  //casto temp useri uz user
                if(user.getNameAndSurnameOrTitle().contains(nameOrSurnameOrTitle)){
                    foundUsers.add(user);
                }
            }
        }
        return foundUsers;
    }

    @Override
    public ArrayList<Page> findPages(String titleOrDescription) throws Exception{
        if(titleOrDescription == null || titleOrDescription.length() < 2){
            throw new Exception("Bad input");
        }

        ArrayList<Page> foundPages = new ArrayList<Page>();


        for(GuestUser temp : MainService.allUsers){
            if(temp instanceof BusinessUser){
                BusinessUser user = (BusinessUser) temp;
                for(Page tPage: user.getListOfPages()){
                    if(tPage.getTitle().toLowerCase().contains(titleOrDescription.toLowerCase()) || tPage.getDescription().toLowerCase().contains(titleOrDescription.toLowerCase())){
                        foundPages.add(tPage);
                    }
                }
            }
        }
        return foundPages;
    }

    @Override
    public ArrayList<Post> findPublicPosts(String msg) throws Exception{
        if(msg == null || msg.length() < 2){
            throw new Exception("What is that message");
        }
        ArrayList<Post> foundPosts = new ArrayList<Post>();

        for(GuestUser temp : MainService.allUsers){
            if(temp instanceof PrivateUser pUser){
                for(Post tPost : pUser.getPublicPosts()){
                    if(tPost.getMsg().toLowerCase().equals(msg.toLowerCase())) {
                        foundPosts.add(tPost);
                    }
                }
            }

            if(temp instanceof BusinessUser){
                BusinessUser user = (BusinessUser) temp;
                for(Page tPage: user.getListOfPages()){
                    for(Post tPost: tPage.getPostsInPage()){
                        if(tPost.getMsg().toLowerCase().equals(msg.toLowerCase())){
                            foundPosts.add(tPost);
                        }
                    }
                }
            }
        }

        return foundPosts;
    }
}
