package rajnikanth.app.tech.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import rajnikanth.app.tech.R;
import rajnikanth.app.tech.adapter.ViewPagerAdapter;
import rajnikanth.app.tech.model.User;

public class UserDetailsActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        try {
            Bundle b = this.getIntent().getExtras();
            assert b != null;
            userArrayList = b.getParcelableArrayList("categories");
            int index = b.getInt("index");
            viewPager = findViewById(R.id.viewPagerHeader);
            if (userArrayList.size() > 0) {
                ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(userArrayList, this, index);
                viewPager.setAdapter(viewPagerAdapter);
                viewPager.setPadding(20, 0, 150, 0);
                viewPagerAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
