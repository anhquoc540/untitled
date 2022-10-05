package model;

import java.util.List;

public class Request {
    private int id;
    private String duration;
    private String start_time;
    private String end_time;
    private List<Region> regions;

    public Request(int id, List<Region> regions) {
        this.id = id;

        this.regions = regions;
    }

    public Request(int id, String start_time, String end_time) {
        this.id = id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setStart_time(int start_time) {
        this.start_time = String.valueOf(start_time);
    }

    public void setEnd_time(int end_time) {
        this.end_time = String.valueOf(end_time);
    }
}
