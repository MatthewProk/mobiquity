package requests.users;

import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;
import requests.APIRequestUtils;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static org.testng.Assert.fail;

public class UsersRequests extends APIRequestUtils {

    /**
     * This method:
     * 1. gets user by his username specified in parameters through API request
     * 2. check status code is 200
     * 3. converts received json to real list of java class objects (users objects)
     * 4. check there is only one user with specified username
     *
     * @param userName - username of specified user
     * @return received user
     */
    @Step
    public static User getUsersByUserName(String userName) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(GET_USERS_REQUEST + "?username=" + userName);
        List<User> userFromJSON = GSON.fromJson(response.getBody().asString(), new TypeToken<List<User>>() {
        }.getType());
        if (userFromJSON.size() > 1) {
            fail("There is trouble with DataBase. Username is unique attribute but this method found " + userFromJSON.size()
                    + " users using this username!!! Check DataBase!!!");
        } else if (userFromJSON.isEmpty()) {
            fail("User with username = " + userName + " is absent!");
        }
        return userFromJSON.get(0);
    }
}
