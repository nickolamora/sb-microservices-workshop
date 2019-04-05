package com.nickolamora.userrating.models;

public class Rating {
    private String venueId;
    private int rating;

    public Rating(String venueId, int rating) {
        this.venueId = venueId;
        this.rating = rating;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
