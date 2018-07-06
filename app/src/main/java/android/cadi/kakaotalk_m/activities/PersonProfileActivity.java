package android.cadi.kakaotalk_m.activities;

import android.cadi.kakaotalk_m.FriendList;
import android.cadi.kakaotalk_m.R;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonProfileActivity extends AppCompatActivity {
    private String PersonName;
    private String Msg;
    private Drawable profile_img;
    private Drawable background_img;
    TextView nameView;
    TextView statusView;
    ImageView profile_imgView;
    ImageView background_imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_profile);
//        PersonName = getIntent().getStringExtra("personName");
//        Msg = getIntent().getStringExtra("message");
        int pos = getIntent().getIntExtra("index", -1);
        PersonName = FriendList.friends.get(pos).name;
        Msg = FriendList.friends.get(pos).title;
        this.profile_img = FriendList.friends.get(pos).profile_img;
        this.background_img = FriendList.friends.get(pos).background_img;
        nameView = (TextView) findViewById(R.id.ProfileName);
        statusView = (TextView) findViewById(R.id.ProfileStatusMsg);
        profile_imgView = (ImageView) findViewById(R.id.profile_img_detail);
        background_imgView = (ImageView) findViewById(R.id.profile_background_img);

    }

    @Override
    protected void onStart() {
        super.onStart();
        nameView.setText(PersonName);
        statusView.setText(Msg);
        if (profile_img != null)
            profile_imgView.setBackground(profile_img);
        if (background_img != null)
            background_imgView.setBackground(background_img);
    }
}
