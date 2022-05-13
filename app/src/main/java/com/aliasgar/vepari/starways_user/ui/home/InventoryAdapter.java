package com.aliasgar.vepari.starways_user.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aliasgar.vepari.starways_user.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private List<Inventory> inventoryItems;
    private Context mContext;

    public InventoryAdapter(List<Inventory> inventoryItems, Context mContext) {
        this.inventoryItems = inventoryItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_rcview,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Inventory inventory = inventoryItems.get(position);

        holder.itemName.setText(inventory.getItemName());
        holder.itemPrice.setText(inventory.getItemprice());

        Glide.with(mContext)
                .asBitmap()
                .load(inventory.getItemImg())
                .into(holder.itemImg);
    }

    @Override
    public int getItemCount() {
        return inventoryItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        TextView itemPrice;
        ImageView itemImg;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView){
            super(itemView);

            itemPrice =itemView.findViewById(R.id.item_price);
            itemName = itemView.findViewById(R.id.item_name);
            itemImg = itemView.findViewById(R.id.inventory_img);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
