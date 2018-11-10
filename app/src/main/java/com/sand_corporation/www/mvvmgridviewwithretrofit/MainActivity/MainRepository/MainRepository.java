package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainRepository;

import android.arch.lifecycle.MutableLiveData;

import com.sand_corporation.www.mvvmgridviewwithretrofit.Global.Common;
import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainModel.Category;
import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmgridviewwithretrofit.RestAPI.APIModel.CategoryList;
import com.sand_corporation.www.mvvmgridviewwithretrofit.RestAPI.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public MutableLiveData<ArrayList<MainViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<Category> items;
    public ArrayList<MainViewModel> mainViewModelArrayList;

    public MutableLiveData<ArrayList<MainViewModel>> getArrayListMutableLiveData() {
        items = new ArrayList<>();
        APIService apiService = Common.getAPIService();
        Call<CategoryList> getCategoryList = apiService.getCategoryList();
        getCategoryList.enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                if (response != null && response.body() != null){
                    items = response.body().getCategoryArrayList();
                    Category category;
                    MainViewModel mainViewModel;
                    mainViewModelArrayList = new ArrayList<>();
                    for (int i=0; i<items.size();i++){
                        category = new Category();
                        category.setId(items.get(i).getId());
                        category.setTitle(items.get(i).getTitle());
                        category.setDescription(items.get(i).getDescription());
                        category.setImageUrl(items.get(i).getImageUrl());
                        mainViewModel = new MainViewModel(category);
                        mainViewModelArrayList.add(mainViewModel);
                    }

                    arrayListMutableLiveData.setValue(mainViewModelArrayList);
                }
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {

            }
        });
        return arrayListMutableLiveData;
    }
}
