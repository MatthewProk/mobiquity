package requests.users;

import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.User;
import org.apache.xpath.operations.String;
import requests.APIRequestUtils;

import java.util.List;

import static org.testng.Assert.fail;

public class UserRequests extends APIRequestUtils {

    public static User getUsersByUserName(String userName) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(GET_USERS_REQUEST + "?username=" + userName);
        List<User> userFromJSON = GSON.fromJson(response.getBody().asString(), new TypeToken<List<User>>(){}.getType());
        if(userFromJSON.size() > 1){
            fail("There is trouble with DataBase. Username is unique attribute but this method found " + userFromJSON.size()
                    + " users using this username!!! Check DataBase!!!");
        }
        return userFromJSON.get(0);
    }
}
