package service;

import model.Page;
import model.PostType;
import model.user.BusinessUser;
import model.user.GuestUser;
import model.user.PrivateUser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainService {

    private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();
    public static void main(String[] args){
        GuestUser u1 = new GuestUser();
        GuestUser u2 = new GuestUser();
        PrivateUser u3 = new PrivateUser();
        GuestUser u4 = new GuestUser();
        BusinessUser u5 = new BusinessUser();
        PrivateUser u6 = new PrivateUser("Marta", "Garde", "1234567890Ma");
        BusinessUser u7 = new BusinessUser("Hesburger", "1234567890He", "LV20000000000");




        allUsers.addAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7));
        for(GuestUser temp : allUsers){
            System.out.println(temp);
        }
        try {
            u6.publishPost(PostType.PRIVATE, "Man ir gruti");
            u6.publishPost(PostType.PUBLIC, "Kas notiek");
            u6.publishPost(PostType.PUBLIC, "Tresais posts hihi");
            u6.followPrivateUser(u3);
            u6.followPrivateUser(u7);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("-------------------------------------------------------");
        System.out.println(u6.getUsername() + " private posts -> ");
        System.out.println(u6.getPrivatePosts());
        System.out.println(u6.getUsername() + " public posts -> ");
        System.out.println(u6.getPublicPosts());

        System.out.println(u6.getUsername() + " " + u6.getFollowers() + " followers");


        System.out.println("-------------------------------------------------------");
        try {
            u7.createPage("Hesburgers Ventspils", "Namnam chezzbuger");
            u7.createPage("Hesburgers Daugavpils", "Hesitris hehe");

            u7.publishPostInPage("Hesburgers Ventspils", "ATLAIDE BUGERISHIEM DAUDZ DAUDZ CHESBURGETI PARAADS");
            u7.publishPostInPage("Hesburgers Daugavpils", "sad emoji");
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(u7.getUsername() + ": pages ->");
        for(Page temp : u7.getListOfPages()){
            System.out.println(temp + " ->");
            System.out.println(temp.getPostsInPage());
            System.out.println();
        }

        System.out.println("-------------------------------------------------------");
    }
}
