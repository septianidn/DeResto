package com.example.deresto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deresto.R;
import com.example.deresto.model.Keranjang;

import java.util.ArrayList;

public class KeranjangAdapter extends RecyclerView.Adapter<KeranjangAdapter.KeranjangViewHolder>{

    public class KeranjangViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textQuantity, textNama, textPrice;
        ImageView  imageMenu;

        public KeranjangViewHolder(@NonNull View itemView) {
            super(itemView);
            textQuantity = itemView.findViewById(R.id.textKuantiti);
            textNama = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textHarga);
            imageMenu = itemView.findViewById(R.id.imageMenu);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null)
            {
                listener.onClick(view, listKeranjang.get(getAdapterPosition()));
            }
        }
    }

    public interface onKeranjangViewHolderClick{
        void onClick(View view, Keranjang keranjang);
    }

    public void setListener(onKeranjangViewHolderClick listener) {
        this.listener = listener;
    }

    onKeranjangViewHolderClick listener = null;

    ArrayList<Keranjang> listKeranjang = new ArrayList<>();
    public void setListKeranjang(ArrayList<Keranjang> listKeranjang) {
        this.listKeranjang = listKeranjang;
    }

    @NonNull
    @Override
    public KeranjangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_keranjang, parent, false);
        KeranjangViewHolder viewHolder = new KeranjangViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeranjangViewHolder viewHolder, int position) {
        Keranjang keranjang = listKeranjang.get(position);
        viewHolder.textQuantity.setText(keranjang.quantity.toString());
        viewHolder.textNama.setText(keranjang.nama);
        viewHolder.textPrice.setText(keranjang.price.toString());
        viewHolder.imageMenu.setImageResource(R.drawable.nasi_goreng_homies);
    }

    @Override
    public int getItemCount() {
        return listKeranjang.size();
    }
}
