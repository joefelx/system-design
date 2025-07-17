public class LoggerFramework implements ILoggerFramework{

    private LogLevel logLevel;
    private Destination destination;
    public static LoggerFramework instance = null;

    private LoggerFramework(LogLevel logLevel, DestinationType destinationType) {
        setLogLevel(logLevel);
        setDestination(destinationType);
    };

    public static LoggerFramework getInstance(LogLevel logLevel, DestinationType destinationType) {
        if (instance == null) {
            instance = new LoggerFramework(logLevel, destinationType);
        }

        return instance;
    }

    @Override
    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void setDestination(DestinationType destinationType) {
        this.destination = DestinationFactory.getDestination(destinationType);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= logLevel.ordinal()) {
            destination.log(new Message(message, level));
        }
    }

    public void debug(String msg) { log(LogLevel.DEBUG, msg); }
    public void info(String msg) { log(LogLevel.INFO, msg); }
    public void warning(String msg) { log(LogLevel.WARNING, msg); }
    public void error(String msg) { log(LogLevel.ERROR, msg); }
    public void fatal(String msg) { log(LogLevel.FATAL, msg); }


}
