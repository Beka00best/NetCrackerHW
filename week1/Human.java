package week1;

import java.util.Date;

public class Human {
    private String surname;
    private String name;
    private int age;
    private Address address;
    private Date birth;

    public Human(String surname, String name, int age, Address address, Date birth) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.address = address;
        this.birth = birth;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Date getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", birth=" + birth.getDay() + "." + birth.getMonth() + "." + birth.getYear() +
                '}';
    }
}
