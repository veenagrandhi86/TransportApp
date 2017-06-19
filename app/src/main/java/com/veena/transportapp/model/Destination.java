package com.veena.transportapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by veena on 14/06/17.
 */

public class Destination {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("fromcentral")
    @Expose
    private TimeFromCentral timeFromCentral;

    @SerializedName("location")
    @Expose
    private Location location;

    /**
     * No args constructor for use in serialization
     *
     */
    public Destination() {
    }

    /**
     *
     * @param id
     * @param location
     * @param name
     * @param timeFromCentral
     */
    public Destination(Integer id, String name, TimeFromCentral timeFromCentral, Location location) {
        super();
        this.id = id;
        this.name = name;
        this.timeFromCentral = timeFromCentral;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeFromCentral getFromCentral() {
        return timeFromCentral;
    }

    public void setFromcentral(TimeFromCentral timeFromCentral) {
        this.timeFromCentral = timeFromCentral;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", timeFromCentral=" + timeFromCentral +
                ", location=" + location +
                '}';
    }
}
