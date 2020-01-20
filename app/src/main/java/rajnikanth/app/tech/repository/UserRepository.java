package rajnikanth.app.tech.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import rajnikanth.app.tech.model.User;
import rajnikanth.app.tech.retrofit.ApiRequest;
import rajnikanth.app.tech.retrofit.RetrofitRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {
    private static final String TAG = "UserRepository";
    private ApiRequest apiRequest;

    public UserRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<User>> getUserDetails() {
        final MutableLiveData<List<User>> data = new MutableLiveData<>();
        apiRequest.getUserDetails().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(TAG, "onResponse: " + response);
                if (response.body() != null) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
