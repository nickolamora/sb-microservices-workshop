package com.nickolamora.userrating.resources;

import com.nickolamora.userrating.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rating")
public class UserRating {

    @RequestMapping("/{venueId}")
    public Rating getRating(@PathVariable("venueId") String venueId) {
        return new Rating(venueId, 5);
    }
}
