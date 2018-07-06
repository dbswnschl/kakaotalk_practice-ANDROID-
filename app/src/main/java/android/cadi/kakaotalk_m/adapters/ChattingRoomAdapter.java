package android.cadi.kakaotalk_m.adapters;

import android.cadi.kakaotalk_m.ChattingListItem;
import android.cadi.kakaotalk_m.ChattingRoom;
import android.cadi.kakaotalk_m.R;
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
 * Created by yunjun on 2018. 7. 1..
 */

public class ChattingRoomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ChattingListItem> listItems;

    public void AddRoom(ChattingRoom.Chatmsg room, String roomName, @Nullable Drawable profile_img) {
        ChattingListItem item = new ChattingListItem();
        item.TimeNow = room.chattedTime;
        item.PersonName = roomName;
        item.Msg = room.messageContent;
        item.profileImage = profile_img;
        listItems.add(item);

    }

    public void AddItem(String personName, String msg, String timeNow) {
        ChattingListItem item = new ChattingListItem();
        item.TimeNow = timeNow;
        item.Msg = msg;
        item.PersonName = personName;
        listItems.add(item);
    }

    public ChattingRoomAdapter(Context context) {
        super();
        this.context = context;
        listItems = new ArrayList<ChattingListItem>();
    }

    ArrayList<ChattingListItem> roomLists;

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.customlist_chatting_rooms, null);
        TextView nameView = (TextView) convertView.findViewById(R.id.personName);
        TextView timeView = (TextView) convertView.findViewById(R.id.nowTime);
        TextView msgView = (TextView) convertView.findViewById(R.id.msg);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.dialog_profile_img);
        nameView.setText(listItems.get(position).PersonName);
        msgView.setText(listItems.get(position).Msg);
        timeView.setText(listItems.get(position).TimeNow);
        if (listItems.get(position).profileImage != null)
            imgView.setBackground(listItems.get(position).profileImage);
        return convertView;
    }
}
