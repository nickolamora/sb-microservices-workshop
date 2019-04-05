package com.nickolamora.venuedecorator.resources;

import com.nickolamora.venuedecorator.models.Venue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venues")
public class VenueDecorator {

    @RequestMapping("/{venueId}")
    public Venue getVenueDecoration(@PathVariable("venueId") String venueId) {
        return new Venue(venueId, "Chipotle", "TexMex restaurant");
    }
}
