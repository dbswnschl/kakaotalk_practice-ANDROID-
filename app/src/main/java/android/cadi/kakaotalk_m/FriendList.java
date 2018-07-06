package android.cadi.kakaotalk_m;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by yunjun on 2018. 7. 6..
 */

public class FriendList {
    public static ArrayList<Friend> friends;

    public static class Friend{
        public String name;
        public Drawable profile_img;
        public Drawable background_img;
        public String title;

    }

    public FriendList() {
        super();
        friends = new ArrayList<Friend>();

    }
    public void AddFriend(String name, String title, @Nullable Drawable profile_img, @Nullable Drawable background_img){
        Friend friend = new Friend();
        friend.name = name;
        friend.title = title;
        friend.profile_img = profile_img;
        friend.background_img = background_img;
        friends.add(friend);
    }


}
