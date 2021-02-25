package api;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static checkers.CommentChecker.checkAllPostsOfUserDoesNotHaveEmptyTitle;
import static models.User.UserEnum.DELPHINE;
import static testutils.TestGroups.IMPLEMENTED;

public class MQ_0000_02_EXTRA_TEST_EmptyPostsComments {

    // These are additional tests to complete the report.

    @Description("Preconditions: there is username = 'Delphine'." +
            "Get user using username='Delphine' through API request '/users'" +
            "Get userId from received user" +
            "Get posts list of this user by userId through API request '/posts'" +
            "Check there are no posts with empty title")
    @Title("Posts Titles")
    @Test(groups = {IMPLEMENTED})
    public void MQ_test_0000_02_MG() {
        checkAllPostsOfUserDoesNotHaveEmptyTitle(DELPHINE.getUserName());
    }
}
