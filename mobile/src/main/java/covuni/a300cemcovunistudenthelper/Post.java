package covuni.a300cemcovunistudenthelper;

/**
 * Created by Holmesy on 03/12/2017.
 */

public class Post {

    String postId;
    String post;

    public Post() {
    }

    public Post (String postId, String post){
        this.postId = postId;
        this.post = post;


    }


    public String getPostId(){
        return postId;
    }

    public String getPost(){
        return post;
    }


}
