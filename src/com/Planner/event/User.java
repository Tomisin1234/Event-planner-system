package com.Planner.event;

import java.util.UUID;

public class User {

    private String userId;
    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String password;
    private String phoneNumber;


    public User() {
        this.userId = UUID.randomUUID().toString(); // auto-generate ID
    }


    public User(String firstname, String lastname, int age,
                String email, String password, String phoneNumber) {
        this.userId = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public String getUserId() {return userId;
    }
    public String getFirstname() {return firstname;
    }
    public String getLastname() { return lastname;
    }
    public int getAge() { return age;
    }
    public String getEmail() { return email;
    }
    public String getPassword() { return password;
    }
    public String getPhoneNumber() { return phoneNumber;
    }


    public void setFirstname(String firstname){ this.firstname = firstname;
    }

    public void setLastname(String lastname) { this.lastname = lastname;
    }

    public void setAge(int age) { this.age = age;
    }

    public void setEmail(String email) { this.email = email;
    }

    public void setPassword(String password) { this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Name: " + firstname + " " + lastname +
                " | Age: " + age +
                " | Email: " + email +
                " | Phone: " + phoneNumber +
                " | ID: " + userId;
    }
}