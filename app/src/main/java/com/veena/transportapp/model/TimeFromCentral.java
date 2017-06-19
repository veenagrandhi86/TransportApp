package com.veena.transportapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by veena on 14/06/17.
 */

public class TimeFromCentral {

    @SerializedName("car")
    @Expose
    private String byCar;

    @SerializedName("train")
    @Expose
    private String byTrain;

    /**
     * No args constructor for use in serialization
     *
     */
    public TimeFromCentral() {
    }

    /**
     *
     * @param byCar
     * @param byTrain
     */
    public TimeFromCentral(String byCar, String byTrain) {
        this.byCar = byCar;
        this.byTrain = byTrain;
    }

    public String getByCar() {
        return byCar;
    }

    public void setByCar(String byCar) {
        this.byCar = byCar;
    }

    public String getByTrain() {
        return byTrain;
    }

    public void setByTrain(String byTrain) {
        this.byTrain = byTrain;
    }

    @Override
    public String toString() {
        return "TimeFromCentral{" +
                "byCar='" + byCar + '\'' +
                ", byTrain='" + byTrain + '\'' +
                '}';
    }
}
