public class User {
    private String name;
    public User(String s) {
        name=s;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        User u = (User) o;
        return name==u.name;
    }
}
