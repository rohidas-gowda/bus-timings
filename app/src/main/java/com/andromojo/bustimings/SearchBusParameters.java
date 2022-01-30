package com.andromojo.bustimings;

public class SearchBusParameters {
    private int id;
    private String source;
    private String destination;
    private String via;
    private String service;
    private String timings;
    private String station;
    private int stationSerialNo;

    public SearchBusParameters(int id, String source, String destination, String via, String service, String timings, String station, int stationSerialNo) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.via = via;
        this.service = service;
        this.timings = timings;
        this.station = station;
        this.stationSerialNo = stationSerialNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getStationSerialNo() {
        return stationSerialNo;
    }

    public void setStationSerialNo(int stationSerialNo) {
        this.stationSerialNo = stationSerialNo;
    }
}
