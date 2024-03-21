package service;

import model.Page;
import model.Post;
import model.user.User;

import java.util.ArrayList;

public interface IGuestUserService {
    //var nerakstit public un abstract jo ta jebkura gadijuma bus public un abstract
    public abstract ArrayList<User> findUsers(String nameOrSurnameOrTitle) throws Exception;
    public abstract ArrayList<Page> findPages(String titleOrDescription) throws Exception;
    public abstract ArrayList<Post> findPublicPosts(String msg)throws Exception;
}
