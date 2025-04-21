package com.example.onlineshop_1.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlineshop_1.domain.BannerModel;
import com.example.onlineshop_1.domain.CategoryModel;
import com.example.onlineshop_1.repository.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private final MainRepository repository = new MainRepository();

    public LiveData<ArrayList<CategoryModel>> loadCategory() {
        return repository.loadCategory();
    }

    public LiveData<ArrayList<BannerModel>> loadBanner() {
        return repository.loadBanner();
    }
}
