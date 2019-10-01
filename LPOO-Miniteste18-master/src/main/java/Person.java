public abstract class Person extends User implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        super(name,age);
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Person) o).getName());
    }
}
