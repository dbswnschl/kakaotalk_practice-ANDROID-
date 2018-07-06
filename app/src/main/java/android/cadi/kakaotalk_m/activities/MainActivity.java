package android.cadi.kakaotalk_m.activities;

import android.cadi.kakaotalk_m.R;
import android.cadi.kakaotalk_m.fragments.ChattingRoomListFragment;
import android.cadi.kakaotalk_m.fragments.FriendListFragment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new FriendListFragment();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("친구"));
        tabLayout.addTab(tabLayout.newTab().setText("대화"));
        tabLayout.addTab(tabLayout.newTab().setText("설정"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                try {
                    if (position == 0) {
                        fragment = new FriendListFragment();
                    } else if (position == 1) {
                        fragment = new ChattingRoomListFragment();
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, fragment, null).commit();
                } catch (NullPointerException exc) {
                    Log.e("NULL 포인터 에러", "탭메뉴의 설정값을 벗어남");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportFragmentManager().beginTransaction().replace(R.id.empty_view, fragment, null).commit();
    }
}
