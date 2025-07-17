public interface ILoggerFramework {

     void setLogLevel(LogLevel logLevel) ;

     void setDestination(DestinationType destinationType) ;

     void log(LogLevel level, String message);
}
