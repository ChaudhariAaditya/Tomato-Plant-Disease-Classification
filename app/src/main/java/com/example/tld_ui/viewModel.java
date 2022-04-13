package com.example.tld_ui;

import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

public class viewModel extends ViewModel {
    private final MutableLiveData<String> result = new MutableLiveData<String>();
    private final MutableLiveData<Bitmap> image = new MutableLiveData<Bitmap>();

    public void setResult(String item) {
        result.setValue(item);
    }

    public LiveData<String> getResult() {
        return result;
    }

    public void setImage(Bitmap item) {
        image.setValue(item);
    }

    public LiveData<Bitmap> getImage() {
        return image;
    }

}