package checkers;

import models.Comment;
import models.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static requests.comments.CommentsRequests.getCommentsByPost;
import static requests.posts.PostsRequests.getPostsByUsers;
import static requests.users.UsersRequests.getUsersByUserName;

public class CommentChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentChecker.class);
    private static final String EMAIL_VALIDATION = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
            ")*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

    /**
     * This method:
     * 1. gets user by username
     * 2. gets all posts related to received user
     * 3. gets all comments related to received posts
     * 4. check all emails inside received comments have property format
     *
     * @param userName of specified user
     */
    @Step
    public static void checkUserPostsCommentsEmailsHavePropertyFormat(String userName) {

        // SoftAssert is more suitable in this case then typical Assert because
        // there is opportunity to check all emails at once
        // Using typical Assert test will be failed after 1st invalid email
        SoftAssert softAssert = new SoftAssert();
        Pattern pattern = compile(EMAIL_VALIDATION);

        // Get posts of user with specified username
        List<Post> posts = getPostsByUsers(getUsersByUserName(userName));
        if (posts.isEmpty()) {
            LOGGER.info("There are no invalid emails in post comments, because user " + userName + " does not have posts!");
        }

        // Get all comments related to received posts
        List<Comment> comments = new ArrayList<>();
        posts.forEach(post -> comments.addAll(getCommentsByPost(post)));
        if (comments.isEmpty()) {
            LOGGER.info("There are no invalid emails in post comments, because user " + userName + " does not have any comments on his/her post!");
        }

        // Check all emails related to given comments
        comments.forEach(comment -> {
            Matcher matcher = pattern.matcher(comment.getEmail());
            softAssert.assertTrue(matcher.matches(), "Email " + comment.getEmail() + " is not valid!");
        });
        softAssert.assertAll();
    }
}
