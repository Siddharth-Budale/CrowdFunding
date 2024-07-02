package com.kappa.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "reviews")
public class Reviews {
    private ObjectId id;
    private String body;

    public Reviews(String body) {
        this.body = body;
    }
}
