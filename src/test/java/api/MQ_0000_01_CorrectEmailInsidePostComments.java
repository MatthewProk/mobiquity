package api;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static checkers.CommentChecker.checkUserPostsCommentsEmailsHavePropertyFormat;
import static models.User.UserEnum.DELPHINE;

/**
 * This class is test class which checks correct email format in post comments.
 * 1 class = 1 test
 * MQ_0000_01:
 * 1. MQ - name of project
 * 2. 0000 - number of story
 * 3. 01 - number of test related to current story
 */
public class MQ_0000_01_CorrectEmailInsidePostComments {

    // I think all things related to how we need to make out our tests are discussed by the team.
    // I chose this way because it is convenient for me in this moment but in general
    // I would make decisions related to it with team

    // I know about "Given When Then", but I enjoy another style (see @Description)

    /**
     * This test method checks correct email format in post comments
     * mq_test_0000_01:
     * 1. mq - name of project
     * 2. 0000 - number of story
     * 3. 01 - number of test related to given story
     *
     * @Description has checklist of current test
     * @Title - title of test
     */
    @Description("Preconditions: there is username = 'Delphine'." +
            "Get user using username='Delphine' through API request '/users'" +
            "Get userId from received user" +
            "Get posts list of this user by userId through API request '/posts'" +
            "Get all postId from received posts list" +
            "Get all comments related to received posts using postId through API request '/comments'" +
            "Check all emails inside received comments have property format")
    @Title("Post Comments Emails property format ")
    @Test
    public void mq_test_0000_01() {
        checkUserPostsCommentsEmailsHavePropertyFormat(DELPHINE.getUserName());
    }
}
