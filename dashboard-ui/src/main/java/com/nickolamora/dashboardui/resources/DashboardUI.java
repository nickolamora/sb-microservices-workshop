package com.nickolamora.dashboardui.resources;

import com.nickolamora.dashboardui.models.DashboardItem;
import com.nickolamora.dashboardui.models.Rating;

import com.nickolamora.dashboardui.models.RatingsList;
import com.nickolamora.dashboardui.models.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Tells Spring that this is a controller that handles API mappings to methods
@RestController
//Map this API to this controller
@RequestMapping("/dashboard")
public class DashboardUI {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClient;

    @RequestMapping("/{userId}")
    public List<DashboardItem> getDashboard(@PathVariable("userId") String userId) {

        // get all rated venue IDs Hardcoded
//        List<Rating> ratings = Arrays.asList(
//                new Rating("1234", 4),
//                new Rating("5678", 5)
//        );

        // get all rated venue IDs
        RatingsList ratings = webClient.build()
                .get()
                .uri("http://localhost:8083/rating/users/" + userId)
                .retrieve()
                .bodyToMono(RatingsList.class)
                .block();

        return ratings.getRatings().stream()
                .map(rating -> {
                    // for each ID, call venue decorator and get details
                    Venue venue = webClient.build()
                            .get()
                            .uri("http://localhost:8082/venues/" + rating.getVenueId())
                            .retrieve()
                            .bodyToMono(Venue.class)
                            .block();
                    // Put them all together
                    return new DashboardItem(venue.getName(), venue.getDescription(), rating.getRating());
                }).collect(Collectors.toList());

//        RestTemplate
//        return ratings.stream().map(rating -> {
//            // for each ID, call venue decorator and get details
//            Venue venue = restTemplate.getForObject("http://localhost:8082/venues/" + rating, Venue.class);
//            // Put them all together
//            return new DashboardItem(venue.getName(), venue.getDescription(), rating.getRating());
//        }).collect(Collectors.toList());
    }
}

