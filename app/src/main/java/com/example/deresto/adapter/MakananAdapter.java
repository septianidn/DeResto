package com.example.deresto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.R;
import com.example.deresto.model.Makanan;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {

    public class MakananViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textmenumakanan, textratingmakanan, texthargamakanan;
        ImageView imageimgmakanan, imagestar, imageplus;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            textmenumakanan = itemView.findViewById(R.id.menumakanan);
            textratingmakanan = itemView.findViewById(R.id.ratingmakanan);
            texthargamakanan = itemView.findViewById(R.id.hargamakanan);
            imageimgmakanan = itemView.findViewById(R.id.imgmakanan);
            imagestar = itemView.findViewById(R.id.star);
            imageplus = itemView.findViewById(R.id.plus);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public interface onMakananViewholderClick {

    }

    ArrayList<Makanan> listMakanan = new ArrayList<>();
    public void setListMakanan(ArrayList<Makanan> listMakanan) {
        this.listMakanan = listMakanan;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_makanan, parent, false);
        MakananViewHolder viewHolder = new MakananViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder viewHolder, int position) {
       Makanan makanan = listMakanan.get(position);
       viewHolder.textmenumakanan.setText(makanan.menumakanan);
       viewHolder.textratingmakanan.setText(makanan.ratingmakanan);
       viewHolder.texthargamakanan.setText("Rp "+makanan.hargamakanan.toString());
       viewHolder.imageimgmakanan.setImageResource(R.drawable.nasi_goreng_homies);
       viewHolder.imagestar.setImageResource(R.drawable.ic_baseline_star_rate_24);
       viewHolder.imageplus.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }


}
