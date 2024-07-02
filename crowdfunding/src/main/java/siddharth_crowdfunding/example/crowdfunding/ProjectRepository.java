package siddharth_crowdfunding.example.crowdfunding;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends MongoRepository<Project, ObjectId> {
    Optional<Project> findByName(String name);
}
