package com.jayd.swissarmyknife.models;

import com.jayd.swissarmyknife.R;

public class TimeSlot {
    public enum TimeFormat{
        TwelveHour,
        TwentyFourHour
    }

    private int startTime;
    private String timeLabel;
    public TimeSlot(int startTime){
        this.startTime = startTime;
        timeLabel = timeToLabel(TimeFormat.TwelveHour);
    }

    public String timeToLabel(TimeFormat timeFormat){
        switch(timeFormat){
            case TwelveHour:
                return startTime >= 12 ? (startTime - 12) + " PM" : startTime + " AM";
            case TwentyFourHour:
                return Integer.toString(startTime) + ":00";
            default:
                return Integer.toString(R.string.time_not_found);
        }
    }
}
