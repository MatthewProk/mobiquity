package requests.posts;

import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Post;
import models.User;
import requests.APIRequestUtils;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static checkers.ResponseStatusChecker.checkResponseStatusCodeIsOK;

public class PostsRequests extends APIRequestUtils {

    /**
     * This method:
     * 1. gets all posts related to user specified in parameters by API
     * 2. check status code is 200
     * 3. converts received json to real list of java class objects (posts objects)
     *
     * @param user - user object
     * @return list of posts objects related to user specified in method parameters
     */
    @Step
    public static List<Post> getPostsByUsers(User user) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(GET_POSTS_REQUEST + "?userId=" + user.getId());
        checkResponseStatusCodeIsOK(response, "Failed to find posts for user = " + user.getUserName() + " !!!");
        return GSON.fromJson(response.getBody().asString(), new TypeToken<List<Post>>(){}.getType());
    }
}
