package data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public  class MainViewModel extends ViewModel{
    public String editTextContents = "You Clicked Me!";
   // public MutableLiveData<String> editTextContents = new MutableLiveData<>();

    public MutableLiveData<Boolean> isSelected = new MutableLiveData<>(false);
}