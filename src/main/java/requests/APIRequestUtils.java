package requests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static config.Config.getBaseUrl;

public class APIRequestUtils {

    protected static final Gson GSON = new GsonBuilder().create();
    protected static final String GET_USERS_REQUEST = getBaseUrl() + "/users";
}
