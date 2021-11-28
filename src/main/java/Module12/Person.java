package Module12;

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String post;

    public Person(String name, String surname, int age, String post) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(post, person.post);
    }

    @Override
    public String toString() {
        return name + " " + surname + ": age " + age + ", post " + post + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
