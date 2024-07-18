package siddharth_crowdfunding.example.crowdfunding;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRepository extends MongoRepository<Password, ObjectId> {
    Optional<Password> findByUsername(String username);
}
