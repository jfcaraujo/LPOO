public abstract class User {
    private String username;

    public User(String name, int age) {
        username=name+age;
    }


    public String getUsername() {
        return username;
    }
}
