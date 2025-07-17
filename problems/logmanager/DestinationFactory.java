public class DestinationFactory {

    public static Destination getDestination(DestinationType type) {
        return switch (type) {
            case FILE -> new File();
            case CONSOLE -> new Console();
        };
    }
}
