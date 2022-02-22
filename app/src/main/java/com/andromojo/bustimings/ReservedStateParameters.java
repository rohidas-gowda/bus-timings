package com.andromojo.bustimings;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservedStateParameters {
    private int reservedId;
    private String reservedSource;
    private String reservedDestination;
    private String reservedTimings;
    private String reservedStateName;

    public ReservedStateParameters(int reservedId, String reservedSource, String reservedDestination, String reservedTimings, String reservedStateName) {
        this.reservedId = reservedId;
        this.reservedSource = reservedSource;
        this.reservedDestination = reservedDestination;
        this.reservedStateName = reservedStateName;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
            Date dateObj = sdf.parse(reservedTimings);
            this.reservedTimings = new SimpleDateFormat("hh:mm a").format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
    }

    public int getReservedId() {
        return reservedId;
    }

    public void setReservedId(int reservedId) {
        this.reservedId = reservedId;
    }

    public String getReservedSource() {
        return reservedSource;
    }

    public void setReservedSource(String reservedSource) {
        this.reservedSource = reservedSource;
    }

    public String getReservedDestination() {
        return reservedDestination;
    }

    public void setReservedDestination(String reservedDestination) {
        this.reservedDestination = reservedDestination;
    }

    public String getReservedTimings() {
        return reservedTimings;
    }

    public void setReservedTimings(String reservedTimings) {
        this.reservedTimings = reservedTimings;
    }

    public String getReservedStateName() {
        return reservedStateName;
    }

    public void setReservedStateName(String reservedStateName) {
        this.reservedStateName = reservedStateName;
    }
}
