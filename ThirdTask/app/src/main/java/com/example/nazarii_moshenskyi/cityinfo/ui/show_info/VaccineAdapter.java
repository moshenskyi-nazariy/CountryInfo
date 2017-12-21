package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;

import java.util.List;

public class VaccineAdapter extends RecyclerView.Adapter<VaccineAdapter.ViewHolder> {
    private List<Vaccine> vaccines;

    @Override
    public VaccineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vaccines_item, parent, false);
        return new VaccineAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VaccineAdapter.ViewHolder holder, int position) {
        Vaccine vaccine = vaccines.get(position);
        String languageName = vaccine.getName();
        holder.name.setText(languageName);

        String vaccineMessage = vaccine.getMessage();
        holder.message.setText(vaccineMessage);
    }

    public void update(List<Vaccine> vaccines) {
        if(vaccines != null) {
            this.vaccines = vaccines;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return vaccines.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView message;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.vaccine_name);
            message = itemView.findViewById(R.id.vaccine_message);
        }
    }
}