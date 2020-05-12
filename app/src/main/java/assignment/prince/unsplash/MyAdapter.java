package assignment.prince.unsplash;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class MyAdapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    public MyAdapter(Context c, FragmentManager fm, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Nature nature = new Nature();
                return nature;
            case 1:
                Pet pet = new Pet();
                return pet;


            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}