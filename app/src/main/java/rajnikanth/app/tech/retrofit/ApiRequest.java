package rajnikanth.app.tech.retrofit;

import java.util.List;

import rajnikanth.app.tech.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("users")
    Call<List<User>> getUserDetails();
}
