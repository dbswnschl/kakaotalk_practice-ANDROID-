package android.cadi.kakaotalk_m.fragments;

import android.cadi.kakaotalk_m.FriendList;
import android.cadi.kakaotalk_m.R;
import android.cadi.kakaotalk_m.activities.PersonProfileActivity;
import android.cadi.kakaotalk_m.adapters.CustomAdapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FriendListFragment extends Fragment {
    ListView listView;
    Context context;
    TextView counter;
    TextView toptitle;
    FriendList friendList;

    public FriendListFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend_list, null);
        listView = (ListView) view.findViewById(R.id.list_friends);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        counter = getActivity().findViewById(R.id.friends_count);
        toptitle = getActivity().findViewById(R.id.friends_top);
        friendList = new FriendList();

        friendList.AddFriend("아이유", "안녕하세요", getResources().getDrawable(R.drawable.iu_profile), getResources().getDrawable(R.drawable.iu_background));
        friendList.AddFriend("친구2", "친구2 입니다.", null, null);
        friendList.AddFriend("친구3", "친구3 입니다.", null, null);
        friendList.AddFriend("친구4", "친구4 입니다.", null, null);
        friendList.AddFriend("친구5", "친구5 입니다.", null, null);
        friendList.AddFriend("친구6", "친구6 입니다.", null, null);
        friendList.AddFriend("친구7", "친구7 입니다.", null, null);
        friendList.AddFriend("친구8", "친구8 입니다.", null, null);
        friendList.AddFriend("친구9", "친구9 입니다.", null, null);
        friendList.AddFriend("친구10", "친구10 입니다.", null, null);
        friendList.AddFriend("친구11", "친구11 입니다.", null, null);
        friendList.AddFriend("친구12", "친구12 입니다.", null, null);
    }

    @Override
    public void onStart() {
        super.onStart();
        CustomAdapter adapter = new CustomAdapter(context);

        for (int i = 0; i < friendList.friends.size(); i++) {
            adapter.AddFriend(friendList.friends.get(i));
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String personName = ((TextView) view.findViewById(R.id.Name)).getText().toString();
                String msg = ((TextView) view.findViewById(R.id.status_msg)).getText().toString();
//                Drawable profile_resource = ((ImageView)view.findViewById(R.id.profile_img)).getBackground();
                Intent intent = new Intent(context, PersonProfileActivity.class);
//                intent.putExtra("personName",personName);
//                intent.putExtra("message",msg);
                intent.putExtra("index", position);
                context.startActivity(intent);

            }
        });
        toptitle.setText("친구");
        counter.setText(listView.getCount() + "");
    }


}
