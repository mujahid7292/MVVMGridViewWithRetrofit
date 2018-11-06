package com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.GridViewAdapter.GridViewAdapter;
import com.sand_corporation.www.mvvmgridviewwithretrofit.MainActivity.MainViewModel.MainViewModel;
import com.sand_corporation.www.mvvmgridviewwithretrofit.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private GridViewAdapter mAdapter;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<MainViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<MainViewModel> mainViewModels) {
                mAdapter = new GridViewAdapter(mainViewModels,MainActivity.this);
                gridView.setAdapter(mAdapter);
                Toast.makeText(MainActivity.this, "" + mainViewModels.size(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
