package boot.spring.po;

public class OutputChat {
    public String cid;
    public String uid;
    public String chat_data;
    public String chat_time;

    public OutputChat() {
    }

    public OutputChat(String cid, String uid, String chat_data, String chat_time) {
        this.cid = cid;
        this.uid = uid;
        this.chat_data = chat_data;
        this.chat_time = chat_time;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getChat_data() {
        return chat_data;
    }

    public void setChat_data(String chat_data) {
        this.chat_data = chat_data;
    }

    public String getChat_time() {
        return chat_time;
    }

    public void setChat_time(String chat_time) {
        this.chat_time = chat_time;
    }

    @Override
    public String toString() {
        return "OutputChat{" +
                "cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", chat_data='" + chat_data + '\'' +
                ", chat_time='" + chat_time + '\'' +
                '}';
    }
}
