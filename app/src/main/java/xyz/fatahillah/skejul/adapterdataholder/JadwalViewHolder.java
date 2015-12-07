package xyz.fatahillah.skejul.adapterdataholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import xyz.fatahillah.skejul.R;

/**
 * Created by root on 12/5/15.
 */
public class JadwalViewHolder extends RecyclerView.ViewHolder {

    TextView tv1, tv2, tv3;


    public JadwalViewHolder(View itemView) {
        super(itemView);

        tv1 = (TextView) itemView.findViewById(R.id.nama_matkul);
        tv2 = (TextView) itemView.findViewById(R.id.jam_mulai);
        tv3 = (TextView) itemView.findViewById(R.id.ruangan);

    }
}
