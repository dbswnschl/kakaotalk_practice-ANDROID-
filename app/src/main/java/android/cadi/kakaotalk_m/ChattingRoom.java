package android.cadi.kakaotalk_m;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by yunjun on 2018. 7. 6..
 */

public class ChattingRoom {
    public String roomName;
    Context context;

    public class Chatmsg {
        public String messageContent;
        public String chattedTime;
        public String chattedDate;

        public Chatmsg(String content, String time, String date) {
            this.messageContent = content;
            this.chattedTime = time;
            this.chattedDate = date;
        }
    }

    public ArrayList<Chatmsg> messages;

    public ChattingRoom(Context context,String roomName) {
        super();
        this.context = context;
        messages = new ArrayList<Chatmsg>();
        this.roomName = roomName;

    }
    public void addMessage(String msg, String time, String date) {
        Chatmsg chatmsg = new Chatmsg(msg, time, date);
        this.messages.add(chatmsg);

    }

    public Chatmsg getRoomProperty(){
        return messages.get(messages.size()-1);
    }
}
