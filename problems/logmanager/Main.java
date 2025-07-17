public class Main {
    public static void main(String[] args) {
        LoggerFramework lf = LoggerFramework.getInstance(LogLevel.DEBUG, DestinationType.CONSOLE);

        lf.info("Hello");
        lf.debug("this is after setting log level");
    }
}
