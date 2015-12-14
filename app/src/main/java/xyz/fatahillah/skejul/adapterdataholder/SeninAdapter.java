package xyz.fatahillah.skejul.adapterdataholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.fatahillah.skejul.R;
import xyz.fatahillah.skejul.activity.DetailActivity;

/**
 * Created by root on 12/5/15.
 */
public class SeninAdapter extends RecyclerView.Adapter<JadwalViewHolder> {

    String[] senin = {"Senin 1", "Kuliah 2", "Kuliah 3", "Kuliah 4", "Kuliah 5", "Kuliah 6", "Kuliah 7", "Kuliah 8", "Kuliah 9", "Kuliah 10", "Kuliah 11"};
    String[] jam = {"07.00", "08.00", "09.00", "10.00", "11.00", "12.00", "13.00", "14.00", "15.00", "16.00", "17.00"};

    Context context;
    LayoutInflater inflater;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);
            //Snackbar.make(v, "Mantap", Snackbar.LENGTH_SHORT).show();

        }
    };

    public SeninAdapter(Activity context) {
        this.context = context;


        inflater = LayoutInflater.from(context);

    }

    @Override
    public JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.cardview_jadwal, parent, false);

        JadwalViewHolder viewHolder = new JadwalViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JadwalViewHolder holder, int position) {


        holder.tv1.setText(senin[position]);
        holder.tv2.setText(jam[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.tv3.setText("Telmat 3");


    }

    @Override
    public int getItemCount() {
        return senin.length;
    }

}
