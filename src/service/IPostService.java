package service;

import model.PostType;

public interface IPostService {
    public abstract void publishPost(PostType type, String message) throws Exception;

}
