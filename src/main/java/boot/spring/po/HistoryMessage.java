package boot.spring.po;

public class HistoryMessage {
    public String uid;
    public String username;
    public String chat_data;
    public String chat_time;

    public HistoryMessage() {
    }

    public HistoryMessage(String uid, String username, String chat_data, String chat_time) {
        this.uid = uid;
        this.username = username;
        this.chat_data = chat_data;
        this.chat_time = chat_time;
    }
}
