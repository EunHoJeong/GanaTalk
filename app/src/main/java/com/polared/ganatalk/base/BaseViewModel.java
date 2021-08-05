package com.polared.ganatalk.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<T> extends ViewModel {
    private MutableLiveData<T> mutableLiveData;

    public MutableLiveData<T> getCurrentName() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    public void postValue(T value) {
        mutableLiveData.postValue(value);
    }
}
