public abstract class Contact {
    private String name;
    private static int idMax = 0;
    private int id;

    public Contact(String name) {
        this.name = name;
        id = ++idMax;
    }

    public int getId() {
        return id;
    }
}