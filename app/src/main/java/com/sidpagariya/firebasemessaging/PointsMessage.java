package com.sidpagariya.firebasemessaging;

/**
 * Created by Siddhant on 1/6/17.
 */

public class PointsMessage {
    private String team;
    private String points;

    public PointsMessage(){

    }

    public PointsMessage(String t, String m){
        this.points = m;
        this.team = t;
    }

    public String getAuthor() {
        return team;
    }

    public String getMessage() {
        return points;
    }
}
