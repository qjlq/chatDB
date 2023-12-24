package boot.spring.po;

public class SaveMessage {
    // cid
    public String cid;

    // uid
    public String uid;

    // 发送的文本
    public String chat_data;

    public String chat_time;

    public SaveMessage() {
    }

    public SaveMessage(String cid, String uid, String text, String time) {
        this.cid = cid;
        this.uid = uid;
        this.chat_data = text;
        this.chat_time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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
        return "SaveMessage{" +
                "cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", text='" + chat_data + '\'' +
                ", time='" + chat_time + '\'' +
                '}';
    }
}
