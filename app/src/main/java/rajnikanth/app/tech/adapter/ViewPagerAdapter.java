package rajnikanth.app.tech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import rajnikanth.app.tech.R;
import rajnikanth.app.tech.model.Address;
import rajnikanth.app.tech.model.Company;
import rajnikanth.app.tech.model.User;

public class ViewPagerAdapter extends PagerAdapter {

    private ArrayList<User> userArrayList;
    private Context context;
    private int index;

    public ViewPagerAdapter(ArrayList<User> userArrayList, Context context, int index) {
        this.userArrayList = userArrayList;
        this.context = context;
        this.index = index;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_details_view, container, false);
        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_userName = view.findViewById(R.id.tv_user_name);
        TextView tv_email = view.findViewById(R.id.tv_email);
        TextView tv_streetName = view.findViewById(R.id.tv_street_name);
        TextView tv_suite = view.findViewById(R.id.tv_suite);
        TextView tv_city = view.findViewById(R.id.tv_city);
        TextView tv_zipcode = view.findViewById(R.id.tv_zipcode);
        TextView tv_company = view.findViewById(R.id.tv_company);
        TextView tv_phoneNumber = view.findViewById(R.id.tv_phone);
        if(index > -1){
            position = index;
            index = -1;
        }
        tv_name.setText(userArrayList.get(position).getName());
        tv_userName.setText(userArrayList.get(position).getUsername());
        tv_email.setText(userArrayList.get(position).getEmail());
        Address address = userArrayList.get(position).getAddress();
        tv_streetName.setText(address.getStreet());
        tv_suite.setText(address.getSuite());
        tv_city.setText(address.getCity());
        tv_zipcode.setText(address.getZipcode());
        Company company = userArrayList.get(position).getCompany();
        tv_company.setText(company.getName());
        tv_phoneNumber.setText(userArrayList.get(position).getPhone());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
