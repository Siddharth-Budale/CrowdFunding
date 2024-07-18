package siddharth_crowdfunding.example.crowdfunding;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Password")
public class Password {

    @Id
    private ObjectId objectId;
    private String username;
    private String password;

    public Password(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ObjectId getObjectId() {
        return objectId;
    }
}
