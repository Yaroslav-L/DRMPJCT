package com.example.drmpjct.ui.profile;

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

import com.example.drmpjct.Food;
import com.example.drmpjct.FoodAdapter;
import com.example.drmpjct.R;
import com.example.drmpjct.databinding.FragmentProfileBinding;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;
    ArrayList<Food> foods = new ArrayList<Food>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Работа со страницей профиль
        RecyclerView recyclerView = binding.recView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setInitialData();
        FoodAdapter adapter = new FoodAdapter(inflater, foods);
        recyclerView.setAdapter(adapter);

        return root;
    }

    //Тестовые данные для проверки профиля
    private void setInitialData() {
        foods.add(new Food ("Банан", "18", R.drawable.banana));
        foods.add(new Food ("Красное Яблоко", "7", R.drawable.apple_red));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}