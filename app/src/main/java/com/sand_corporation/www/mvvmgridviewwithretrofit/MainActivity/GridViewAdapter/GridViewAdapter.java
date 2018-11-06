package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.GridViewAdapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmgridviewwithretrofit.R;
import com.sand_corporation.www.mvvmgridviewwithretrofit.databinding.CategoryBinding;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {

    private ArrayList<MainViewModel> arrayList;
    private Context mContext;
    private CategoryBinding categoryBinding;

    public GridViewAdapter(ArrayList<MainViewModel> arrayList, Context mContext) {
        this.arrayList = arrayList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.single_category,
                    null);
            categoryBinding = DataBindingUtil.bind(convertView);
            convertView.setTag(categoryBinding);
        }else {
            categoryBinding = (CategoryBinding)convertView.getTag();
        }

        categoryBinding.setMainViewModel(arrayList.get(position));

        return categoryBinding.getRoot();
    }
}
