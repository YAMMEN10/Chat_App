package com.myhexaville.UI.Adapter.AdapterRoomChat.Message;


import java.io.Serializable;

public class $_Message implements Serializable {
    private String id;
    private String name;
    private String type;
    private String time;

    public $_Message(String id, String name, String type, String time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
     /*   if (time == null) return "now";
        else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date date = null;
            try {
                System.out.println("Time = "  + time);
                date = simpleDateFormat.parse(time);
                TimeZone timeZone = TimeZone.getDefault();
                int raw_offset = timeZone.getRawOffset();
                long local = 0;
                if (date != null) {
                    local = date.getTime() + raw_offset;
                }
                Calendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(local);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
                return simpleDateFormat1.format(calendar.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return "now";*/

        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
