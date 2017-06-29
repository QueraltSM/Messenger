import java.util.*;
public class Group extends Contact {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private String name;

    public Group(String name) {
        super(name);
        this.name = name;
    }

    public boolean remove(int id) {
        for (Contact i : contacts) {
            if (i instanceof Person) {
                if (i.getId() == id) {
                    contacts.remove(i);
                    return true;
                }
            } else if (i instanceof Group) {
                return (check((Group)i, id, 1));

            }
        }
        return false;
    }

    private boolean check(Group i, int id, int n) {
        for (Contact c : i.getContacts()) {
            if (c instanceof Person) {
                if (c.getId() == id) {
                    if (n == 1) {
                        i.remove(c.getId());
                        return true;
                    } else if (n == 0) {
                        i.add(c);
                        return true;
                    } else if (n == 2) {
                        return true;
                    }
                }

            } else if (c instanceof Group) {
                if (n == 0) {
                    return check((Group) c, id, 0);
                } else if (n == 1) {
                    return check((Group) c, id, 1);
                } else if (n == 2) {
                    if (c.getId() == id) {
                        return true;
                    } else {
                        return check((Group) c, id, 2);
                    }
                }
            }
        }
        return false;
    }

    public boolean add(Contact c) {
        for (Contact i : contacts) {
            if (i instanceof Person) {
                if (i.equals(c)) {
                    return true;
                }
            } else if (i instanceof Group) {
                return check((Group)i, c.getId(), 0);
            }
        }
        contacts.add(c);
        return false;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public String toString() {
        String result = "\n" + this.name + "\n";
        for (Contact i : contacts) {
            if (i instanceof Person) {
                result += ((Person)i).toString() + "\n";
            } else if (i instanceof Group) {
                result += ((Group) i).getContacts().toString();
            }
        }
        return result;

    }


   public boolean isMember(int id) {
       for (Contact i : contacts) {
           if (i instanceof Group) {
               return check((Group)i, id, 2);

           } else if (i instanceof Person) {
             if (i.getId() == id) {
                 return true;
             }
           }
       }
       return false;
   }

}