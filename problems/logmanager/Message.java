import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private final String timeStamp;
    private final LogLevel logLevel;
    private final String message;

    public Message(String message, LogLevel logLevel) {
        this.message = message;
        this.logLevel = logLevel;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
        this.timeStamp = sdf.format(new Date());
    }

    public String getMessage() {
        return timeStamp + " | " + logLevel + " | " + message;
    }
}
