package com.aliasgar.vepari.starways_user.ui.cart;

import static android.content.ContentValues.TAG;
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
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Cart> cartItems;
    private Context mContext;

    public CartAdapter(List<Cart> cartItems, Context mContext) {
        this.cartItems = cartItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_rcview,parent,false);
        CartAdapter.ViewHolder holder = new CartAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Cart cart = cartItems.get(position);

        holder.itemName.setText(cart.getItemName());
        holder.itemPrice.setText(cart.getItemPrice());
        holder.itemQty.setText(cart.getItemQty());

        Glide.with(mContext)
                .asBitmap()
                .load(cart.getItemImg())
                .into(holder.itemImg);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemName;
        TextView itemPrice;
        ImageView itemImg;
        TextView itemQty;
        RelativeLayout parentLayout;
        CartAdapter adapter;

        public ViewHolder(View itemView){
            super(itemView);

            itemView.findViewById(R.id.cart_rmv_btn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adapter.cartItems.remove(getAdapterPosition());
                            adapter.notifyItemChanged(getAdapterPosition());
                        }
                    });

            itemView.findViewById(R.id.cart_plus_btn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int qty =Integer.parseInt(itemQty.getText().toString());
                            if(qty <=24){
                                qty++;
                            }else Snackbar.make(view,"Can't select above 25 pcs",Snackbar.LENGTH_SHORT)
                                    .setAction("Action",null).show();
                           itemQty.setText(String.valueOf(qty)) ;
                        }
                    });

            itemView.findViewById(R.id.cart_subtract_btn)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            int price =Integer.parseInt(itemQty.getText().toString());
                            if(price>0){
                                price--;
                            }else Snackbar.make(view,"Quantity is already 0!",Snackbar.LENGTH_SHORT)
                                    .setAction("Action",null).show();
                            itemQty.setText(String.valueOf(price)) ;
                        }
                    });

            itemQty = itemView.findViewById(R.id.cart_qty_display_tv);
            itemPrice =itemView.findViewById(R.id.cart_item_price);
            itemName = itemView.findViewById(R.id.cart_item_name);
            itemImg = itemView.findViewById(R.id.cart_img);
            parentLayout = itemView.findViewById(R.id.cart_layout);
        }
    }
}
