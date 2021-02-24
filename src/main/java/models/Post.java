package models;

import org.apache.xpath.operations.String;

public class Post {

    private final int userId;
    private final int id;
    private final String title;
    private final String body;

    public Post(int userI, int id, String title, String body) {
        this.userId = userI;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
