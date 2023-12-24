package boot.spring.po;

public class SaveMessage {
    // cid
    public String cid;

    // uid
    public String uid;

    // 发送的文本
    public String text;

    public String time;

    public SaveMessage() {
    }

    public SaveMessage(String cid, String uid, String text, String time) {
        this.cid = cid;
        this.uid = uid;
        this.text = text;
        this.time = time;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "SaveMessage{" +
                "cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", text='" + text + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
