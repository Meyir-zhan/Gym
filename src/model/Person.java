package model;

public abstract class Person {

    protected int id;
    protected String name;
    protected boolean active;

    public Person(int id, String name, boolean active) {
        setId(id);
        setName(name);
        this.active = active;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public abstract void work();
}