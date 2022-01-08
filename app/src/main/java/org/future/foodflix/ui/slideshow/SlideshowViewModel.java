package org.future.foodflix.ui.slideshow;

import android.widget.CheckBox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public String Checked(String url, String string, CheckBox checkBox){
        url+=string;
        if(checkBox.isChecked()){
            url+=checkBox.getText().toString();
        }
        return url;
    }

    public LiveData<String> getText() {
        return mText;
    }
}