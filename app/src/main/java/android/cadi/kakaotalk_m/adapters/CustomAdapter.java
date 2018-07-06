package android.cadi.kakaotalk_m.adapters;

import android.cadi.kakaotalk_m.FriendList;
import android.cadi.kakaotalk_m.NameTitle;
import android.cadi.kakaotalk_m.R;
import android.cadi.kakaotalk_m.ViewHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunjun on 2018. 6. 30..
 */

public class CustomAdapter extends BaseAdapter {

    ArrayList<NameTitle> Names = new ArrayList<NameTitle>();

    private Context context;
    ViewHolder viewHolder;
    public void AddItem(String Name, String Content, @Nullable Drawable profileImg) {
        NameTitle nameTitle = new NameTitle();
        nameTitle.AddName(Name, Content,profileImg);
        Names.add(nameTitle);
    }
    public void AddFriend(FriendList.Friend friend){
        NameTitle nameTitle = new NameTitle();
        nameTitle.AddName(friend.name,friend.title,friend.profile_img);
        Names.add(nameTitle);
    }
    public CustomAdapter(Context context) {
        super();
        this.context = context;


    }

    @Override
    public int getCount() {
        return Names.size();
    }

    @Override
    public Object getItem(int position) {
        return (NameTitle) Names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlist, null);
        TextView nameView = (TextView) convertView.findViewById(R.id.Name);
        TextView statusView = (TextView) convertView.findViewById(R.id.status_msg);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.profile_img);
        nameView.setText(Names.get(position).Name);
        statusView.setText(Names.get(position).Content);
        if(Names.get(position).profileImg != null){

            imageView.setBackground(Names.get(position).profileImg);
        }

        return convertView;
    }
}
