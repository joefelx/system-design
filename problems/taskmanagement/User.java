package taskmanagement;



public class User {
    private static int incrementor = 0;
    private final int id;
    private String name;

    public User(String name) {
        this.id = incrementor++;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
