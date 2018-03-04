package com.jayd.swissarmyknife.models;

public class DayCalendar {
    public TimeSlot[] timeSlots;
    public DayCalendar(){
        initializeTimeSlots();
    }

    private void initializeTimeSlots(){
        timeSlots = new TimeSlot[24];

        for(int i = 0; i < timeSlots.length; ++i){
            timeSlots[i] = new TimeSlot(i);
        }
    }
}
