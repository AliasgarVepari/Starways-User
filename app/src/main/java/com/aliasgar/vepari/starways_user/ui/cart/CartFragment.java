package com.aliasgar.vepari.starways_user.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aliasgar.vepari.starways_user.R;
import com.aliasgar.vepari.starways_user.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {

    private FragmentCartBinding binding;
    private List<Cart> cartItems;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CartViewModel cartViewModel =
                new ViewModelProvider(this).get(CartViewModel.class);

        cartItems = new ArrayList<>();
        binding = FragmentCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initRcView(binding.cartRecyclerView);
        return root;
    }

    private void LoadRcItems(){
        Cart item = new Cart("Samsung LCD","10", R.drawable.lcd_with_touch_screen_for_xiaomi_redmi_9_india_aug_2020_orange_by_maxbhi_com_10250,"$150");
        cartItems.add(item);

        Cart item2 = new Cart("Samsung LCD","15",R.drawable.lcd_with_touch_screen_for_samsung_galaxy_m12_blue_by_maxbhi_com_45527,"$250");
        cartItems.add(item2);

        Cart item3 = new Cart("Samsung LCD","20",R.drawable.lcd_with_touch_screen_for_google_nexus_7_2012_8gb_wifi_1st_gen_black_by_maxbhi_com_94573,"$100");
        cartItems.add(item3);

        Cart item4 = new Cart("Samsung LCD","35",R.drawable.lcd_with_touch_screen_for_asus_zenfone_max_pro_m1_zb601kl_white_by_maxbhi_com_3103,"$175");
        cartItems.add(item4);

        Cart item5 = new Cart("Samsung LCD","41",R.drawable.lcd_with_touch_screen_for_apple_iphone_6s_64gb_rose_gold_by_maxbhi_com_47862,"$215");
        cartItems.add(item5);

        Cart item6 = new Cart("Iphone 6 Battery","45",R.drawable.battery_for_apple_iphone_6s_64gb_by_maxbhi_com_61942,"$30");
        cartItems.add(item6);

        Cart item7 = new Cart("Back Panel Cover for Xiaomi Redmi 9","40", R.drawable.back_panel_cover_for_xiaomi_redmi_9_india_aug_2020_orange_maxbhi_com_90692,"$75");
        cartItems.add(item7);

    }

    private void initRcView(RecyclerView rcView){
        LoadRcItems();
        RecyclerView recyclerView = rcView;
        CartAdapter adapter = new CartAdapter(cartItems,this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}