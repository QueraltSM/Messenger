public class Person extends Contact {
    private String name, tnumber;

    public Person (String name, String tnumber) {
        super(name);
        this.name = name;
        this.tnumber = tnumber;
    }

    public String toString() {
        return name + ": " + tnumber;
    }
}