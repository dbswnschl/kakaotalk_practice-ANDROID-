package android.cadi.kakaotalk_m.fragments;

import android.cadi.kakaotalk_m.ChattingListItem;
import android.cadi.kakaotalk_m.ChattingRoom;
import android.cadi.kakaotalk_m.adapters.ChattingRoomAdapter;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.cadi.kakaotalk_m.R;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChattingRoomListFragment extends Fragment {
    Context context;
    ListView listView;
    TextView counter;
    TextView toptitle;
    ArrayList<ChattingRoom> rooms;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = getActivity().findViewById(R.id.friends_count);
        toptitle = getActivity().findViewById(R.id.friends_top);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chatting_room_list, null);
        listView = (ListView) view.findViewById(R.id.list_chat_rooms);
        context = view.getContext();
        rooms = new ArrayList<ChattingRoom>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        counter.setText("");
        toptitle.setText("대화 목록");
        ChattingRoomAdapter adapter = new ChattingRoomAdapter(context);
//        adapter.AddItem("배달의 민족","안녕하세요 배달의 민족입니다.","오후 11:12");

        /*Dummy Data Setting*/
        ChattingRoom room = new ChattingRoom(context,"아이유");
        room.addMessage("안녕하세요 아이유 입니다.","오후 11:15","2018년 7월 10일");
        room.addMessage("친구 추가해주셔서 감사합니다.","오후 11:16","2018년 7월 10일");
        adapter.AddRoom(room.getRoomProperty(),room.roomName,getResources().getDrawable(R.drawable.iu_profile));
        room = new ChattingRoom(context,"배달의 민족");
        room.addMessage("안녕하세요 배달의 민족 입니다","오후 11:12","2018년 7월 10일");
        adapter.AddRoom(room.getRoomProperty(),room.roomName,null);
        room = new ChattingRoom(context,"베스킨 라빈스 31");
        room.addMessage("안녕하세요 베스킨 라빈스 31 입니다","오후 11:10","2018년 7월 10일");
        adapter.AddRoom(room.getRoomProperty(),room.roomName,null);
        room = new ChattingRoom(context,"카카오톡");
        room.addMessage("안녕하세요 카카오톡 입니다","오후 11:05","2018년 7월 10일");
        adapter.AddRoom(room.getRoomProperty(),room.roomName,null);

        listView.setAdapter(adapter);


    }
}
