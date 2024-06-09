package com.example.roomshowcase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgrammerAdapter extends RecyclerView.Adapter<ProgrammerAdapter.ProgrammerViewHolder> {

    private List<Programmer> programmerList;

    public ProgrammerAdapter(List<Programmer> programmerList) {
        this.programmerList = programmerList;
    }

    @NonNull
    @Override
    public ProgrammerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_programmer, parent, false);
        return new ProgrammerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammerViewHolder holder, int position) {
        Programmer programmer = programmerList.get(position);
        holder.ID.setText("ID: " + programmer.getId());
        holder.firstName.setText(programmer.getName());
        holder.lastName.setText(programmer.getSurname());
        holder.experienceLevel.setText("Experience: " + programmer.getExperienceLevel() + " years");
        holder.isAvailable.setText("Lazy: " + (programmer.isLazy() ? "Yes" : "No"));
    }

    @Override
    public int getItemCount() {
        return programmerList.size();
    }

    public static class ProgrammerViewHolder extends RecyclerView.ViewHolder {
        public TextView ID;
        public TextView firstName;
        public TextView lastName;
        public TextView experienceLevel;
        public TextView isAvailable;

        public ProgrammerViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.programmerId);
            firstName = itemView.findViewById(R.id.firstName);
            lastName = itemView.findViewById(R.id.lastName);
            experienceLevel = itemView.findViewById(R.id.experienceLevel);
            isAvailable = itemView.findViewById(R.id.isAvailable);
        }
    }
}

