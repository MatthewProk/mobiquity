package requests.comments;

import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Comment;
import models.Post;
import requests.APIRequestUtils;

import java.util.List;

import static checkers.ResponseStatusChecker.checkResponseStatusCodeIsOK;

public class CommentsRequests extends APIRequestUtils {

    /**
     * This method:
     * 1. gets all comments related to post specified in parameters by API
     * 2. check status code is 200
     * 3. converts received json to real list of java class objects (comments objects)
     *
     * @param post - user post object
     * @return list of comments objects related to post specified in method parameters
     */
    public static List<Comment> getCommentsByPost(Post post) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(GET_COMMENTS_REQUEST + "?postId=" + post.getId());
        checkResponseStatusCodeIsOK(response, "Failed to find comments by post with id = " + post.getId() + " !!!");
        return GSON.fromJson(response.getBody().asString(), new TypeToken<List<Comment>>(){}.getType());
    }
}
