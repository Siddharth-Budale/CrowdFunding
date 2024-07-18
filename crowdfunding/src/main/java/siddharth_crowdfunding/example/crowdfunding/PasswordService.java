package siddharth_crowdfunding.example.crowdfunding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class PasswordService {
    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean addUser(String username,String password) throws IOException{
        Optional<Password> passwordOptional =passwordRepository.findByUsername(username);
        if(passwordOptional.isEmpty()){
            mongoTemplate.insert(new Password(username, password));
            return true;
        }
        throw new IOException("the username already exists");
    }
    public boolean authentication(String username,String password) throws IOException{
        Optional<Password> passwordOptional= passwordRepository.findByUsername(username);
        if(!passwordOptional.isEmpty()){
            String pass=passwordOptional.get().getPassword();
            if(pass.equals(password)){
                return true;
            }
            return false;
        }
        throw new IOException("User Not found");
    }
}
