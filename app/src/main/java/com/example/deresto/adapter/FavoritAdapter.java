package com.example.deresto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.R;
import com.example.deresto.model.Favorit;

import java.util.ArrayList;

public class FavoritAdapter extends  RecyclerView.Adapter<FavoritAdapter.FavoritViewHolder>{


    public class FavoritViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textmenufav, textratingfav, texthargafav;
        ImageView imageimgfav, imagebintang, imagetambah;

        public FavoritViewHolder(@NonNull View itemView) {
            super(itemView);
            textmenufav = itemView.findViewById(R.id.menufav);
            textratingfav = itemView.findViewById(R.id.ratingfav);
            texthargafav = itemView.findViewById(R.id.hargafav);
            imageimgfav = itemView.findViewById(R.id.imgfav);
            imagebintang = itemView.findViewById(R.id.bintang);
            imagetambah = itemView.findViewById(R.id.tambah);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public interface onFavoritViewholderClick {

    }

    ArrayList<Favorit> listFavorit = new ArrayList<>();
    public void setListFavorit(ArrayList<Favorit> listFavorit) {
        this.listFavorit = listFavorit;
    }

    @NonNull
    @Override
    public FavoritViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_favorit, parent, false);
        FavoritViewHolder viewHolder = new FavoritViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritViewHolder viewHolder, int position) {
        Favorit favorit = listFavorit.get(position);
        viewHolder.textmenufav.setText(favorit.menufav);
        viewHolder.textratingfav.setText(favorit.ratingfav);
        viewHolder.texthargafav.setText("Rp "+favorit.hargafav.toString());
        viewHolder.imageimgfav.setImageResource(R.drawable.nasi_goreng_homies);
        viewHolder.imagebintang.setImageResource(R.drawable.ic_baseline_star_rate_24);
        viewHolder.imagetambah.setImageResource(R.drawable.ic_baseline_add_circle_outline_24);

    }

    @Override
    public int getItemCount() {
        return listFavorit.size();
    }


}
