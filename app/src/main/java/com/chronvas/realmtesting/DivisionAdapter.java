package com.chronvas.realmtesting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Probir Bhowmik on 27-Jan-20. Soft BD Ltd. Email:probirbhowmikcse@gmail.com
 */
public class DivisionAdapter extends RecyclerView.Adapter<NameViewHolder> {

    Context ctx;
    ArrayList<String> names;
    private int selectedPosition = -1;// no selection by default

    public DivisionAdapter(Context ctx, ArrayList<String> names) {
        this.ctx = ctx;
        this.names = names;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View nameView= LayoutInflater.from(ctx).inflate(R.layout.row_name,parent,false);
        NameViewHolder holder = new NameViewHolder(nameView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameHolder, int position) {
        nameHolder.nameTV.setText(names.get(position));
        nameHolder.checkName.setChecked(selectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
}

class NameViewHolder extends RecyclerView.ViewHolder {
    TextView nameTV;
    CheckBox checkName;
    public NameViewHolder(View itemView) {
        super(itemView);
        nameTV=itemView.findViewById(R.id.TV_name);
        checkName=itemView.findViewById(R.id.checkBox);
    }
}
