package ru.catinasw.springcourse.FirstSecurityApp.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(min = 2, max = 100, message = "name should be between 2 and 100 characters")
    @Column(name = "username")
    private String userName;

    @Min(value = 1900, message = "birthday should be greater than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "password")
    private String password;

    public Person() {
    }

    public Person(String userName, int yearOfBirth) {
        this.userName = userName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                '}';
    }
}
