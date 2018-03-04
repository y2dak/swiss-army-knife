package com.jayd.swissarmyknife.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jayd.swissarmyknife.R;
import com.jayd.swissarmyknife.models.TimeSlot;


public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotViewHolder> {
    TimeSlot timeSlots[];

    public TimeSlotAdapter(TimeSlot[] timeSlots){
        this.timeSlots = timeSlots;
    }
    public static class TimeSlotViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView timeSlot;
        TimeSlotViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.timeSlotCardView);
            timeSlot = itemView.findViewById(R.id.timeView);

        }
    }

    @Override
    public int getItemCount() {
        return timeSlots.length;
    }

    @Override
    public TimeSlotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_calendar_day,parent,false);
        return new TimeSlotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TimeSlotViewHolder holder, int position) {
        holder.timeSlot.setText(timeSlots[position].timeToLabel(TimeSlot.TimeFormat.TwelveHour));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
