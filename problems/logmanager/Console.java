public class Console implements Destination{
    @Override
    public void log(Message message) {
        System.out.println(message.getMessage());
    }
}
