package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainModel.Category;
import com.sand_corporation.www.mvvmgridviewwithretrofit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    public Category category;
    public MutableLiveData<ArrayList<MainViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<MainViewModel> mainViewModelArrayList;

    public MainViewModel(Category category) {
        this.category = category;
    }

    public MainViewModel() {

    }

    public String getImageUrl(){
        return  category.imageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Picasso.get().load(imageUrl).placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }

    public MutableLiveData<ArrayList<MainViewModel>> getArrayListMutableLiveData() {
        mainViewModelArrayList = new ArrayList<>();
        Category category = new Category("123","Shoes","Lots of lots of shoes","shoes1.png");
        MainViewModel mainViewModel = new MainViewModel(category);
        mainViewModelArrayList.add(mainViewModel);

        arrayListMutableLiveData.setValue(mainViewModelArrayList);
        return arrayListMutableLiveData;
    }
}
