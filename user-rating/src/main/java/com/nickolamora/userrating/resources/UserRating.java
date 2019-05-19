package com.nickolamora.userrating.resources;

import com.nickolamora.userrating.models.Rating;
import com.nickolamora.userrating.models.RatingsList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class UserRating {

    @RequestMapping("/{venueId}")
    public Rating getRating(@PathVariable("venueId") String venueId) {
        return new Rating(venueId, 5);
    }

    @RequestMapping("/users/{userId}")
    public RatingsList getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 5),
                new Rating("9012", 5));

        RatingsList ratingList = new RatingsList();
        ratingList.setRatings(ratings);
        return ratingList;
    }
}
