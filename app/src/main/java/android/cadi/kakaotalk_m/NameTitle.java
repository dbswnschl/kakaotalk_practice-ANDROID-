package android.cadi.kakaotalk_m;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yunjun on 2018. 6. 30..
 */

public class NameTitle {



    public String Name;
    public String Content;
    public Drawable profileImg = null;



    public void AddName(String name, String content, @Nullable Drawable profileImg){
        Name = name;
        Content = content;
        if(profileImg != null){
            this.profileImg = profileImg;
        }


    }
}
