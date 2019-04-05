package com.nickolamora.venuedecorator.models;

public class Venue {
    private String venueId;
    private String name;
    private String description;

    public Venue(String venueId, String name, String description) {
        this.venueId = venueId;
        this.name = name;
        this.description = description;
    }

    public String getVenueId() {
        return venueId;
    }

    public void setVenueId(String venueId) {
        this.venueId = venueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
