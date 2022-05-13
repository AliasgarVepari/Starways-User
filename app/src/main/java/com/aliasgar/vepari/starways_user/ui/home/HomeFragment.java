package com.aliasgar.vepari.starways_user.ui.home;

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
import com.aliasgar.vepari.starways_user.databinding.FragmentHomeBinding;
import com.aliasgar.vepari.starways_user.ui.cart.Cart;
import com.aliasgar.vepari.starways_user.ui.cart.CartAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<Inventory> inventoryItems;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        inventoryItems = new ArrayList<>();
        final TextView textView = binding.textHome;
        initRcView(binding.inventoryRcview);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void LoadRcItems(){
        Inventory item = new Inventory("Samsung LCD", R.drawable.lcd_with_touch_screen_for_xiaomi_redmi_9_india_aug_2020_orange_by_maxbhi_com_10250,"$150");
        inventoryItems.add(item);

        Inventory item2 = new Inventory("Samsung LCD",R.drawable.lcd_with_touch_screen_for_samsung_galaxy_m12_blue_by_maxbhi_com_45527,"$250");
        inventoryItems.add(item2);

        Inventory item3 = new Inventory("Samsung LCD",R.drawable.lcd_with_touch_screen_for_google_nexus_7_2012_8gb_wifi_1st_gen_black_by_maxbhi_com_94573,"$100");
        inventoryItems.add(item3);

        Inventory item4 = new Inventory("Samsung LCD",R.drawable.lcd_with_touch_screen_for_asus_zenfone_max_pro_m1_zb601kl_white_by_maxbhi_com_3103,"$175");
        inventoryItems.add(item4);

        Inventory item5 = new Inventory("Samsung LCD",R.drawable.lcd_with_touch_screen_for_apple_iphone_6s_64gb_rose_gold_by_maxbhi_com_47862,"$215");
        inventoryItems.add(item5);

        Inventory item6 = new Inventory("Iphone 6 Battery",R.drawable.battery_for_apple_iphone_6s_64gb_by_maxbhi_com_61942,"$30");
        inventoryItems.add(item6);

        Inventory item7 = new Inventory("Back Panel Cover for Xiaomi Redmi 9", R.drawable.back_panel_cover_for_xiaomi_redmi_9_india_aug_2020_orange_maxbhi_com_90692,"$75");
        inventoryItems.add(item7);

    }

    private void initRcView(RecyclerView rcView){
        LoadRcItems();
        RecyclerView recyclerView = rcView;
        InventoryAdapter adapter = new InventoryAdapter(inventoryItems,this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
    }
}