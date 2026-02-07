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


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }


    public void setId(int id) {
        // ID can be 0 when creating new objects for DB auto-generation
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void work();
}