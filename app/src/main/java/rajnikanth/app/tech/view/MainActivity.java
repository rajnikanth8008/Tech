package rajnikanth.app.tech.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rajnikanth.app.tech.R;
import rajnikanth.app.tech.adapter.UserAdapter;
import rajnikanth.app.tech.model.User;
import rajnikanth.app.tech.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private UserAdapter adapter;
    private ArrayList<User> userArrayList = new ArrayList<>();
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        getUsersData();
    }

    private void initialization() {
        recyclerView = findViewById(R.id.rv_users_list);
        layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // adapter
        adapter = new UserAdapter(MainActivity.this, userArrayList);
        recyclerView.setAdapter(adapter);

        // View Model
        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
    }
    private void getUsersData() {
        userViewModel.getUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {
                if (userList != null) {
                    userArrayList.addAll(userList);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
