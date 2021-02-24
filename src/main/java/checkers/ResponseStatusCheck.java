package checkers;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class ResponseStatusCheck {

    /**
     * This method checks that a request is completed with 'status code = 200'
     *
     * @param response from API request
     * @param errorMessage which is displayed in case if request didn't have 'status code = 200'
     */
    public static void checkResponseStatusCodeIsOK(Response response, String errorMessage) {
        if (HttpStatus.SC_OK != response.getStatusCode()) {
            throw new AssertionError(errorMessage + ": " + response.getBody().asString());
        }
    }
}
