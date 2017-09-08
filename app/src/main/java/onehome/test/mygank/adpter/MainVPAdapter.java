package onehome.test.mygank.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import onehome.test.mygank.base.BaseFragment;
import onehome.test.mygank.base.BaseMainFragment;

/**
 * Created by Administrator on 2017/9/8.
 */

public class MainVPAdapter extends FragmentPagerAdapter {
    private List<BaseMainFragment> fragments;

    public MainVPAdapter(FragmentManager fm, List<BaseMainFragment> fragmentList) {
        super(fm);
        this.fragments = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).fragmentTabTitle();
    }
}
