package com.kappa.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private  ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Reviews createReview(String reviewBody, String ImdbId){
        Reviews new_review=reviewRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(ImdbId))
                .apply(new Update().push("reviewIds").value(new_review)).first();

        return  new_review;
    }
}
