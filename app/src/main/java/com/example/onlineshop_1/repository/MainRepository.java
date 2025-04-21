package com.example.onlineshop_1.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.onlineshop_1.domain.CategoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainRepository {

    private final FirebaseDatabase fireDatabase = FirebaseDatabase.getInstance();
    public LiveData<ArrayList<CategoryModel>> loadCategory(){

        MutableLiveData<ArrayList<CategoryModel>> listData = new MutableLiveData<>();
        DatabaseReference ref = fireDatabase.getReference("Category");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<CategoryModel> list = new ArrayList<>();
                for(DataSnapshot childSnapshot:snapshot.getChildren()){
                    CategoryModel item = childSnapshot.getValue(CategoryModel.class);
                    if(item != null) list.add(item);
                }
                listData.setValue(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return listData;
    }
}
