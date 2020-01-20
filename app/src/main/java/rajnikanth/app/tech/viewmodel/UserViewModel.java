package rajnikanth.app.tech.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import rajnikanth.app.tech.model.User;
import rajnikanth.app.tech.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> userLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);

        userRepository = new UserRepository();
        this.userLiveData = userRepository.getUserDetails();
    }

    public LiveData<List<User>> getUserLiveData() {
        return userLiveData;
    }
}