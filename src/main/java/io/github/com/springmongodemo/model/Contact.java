package io.github.com.springmongodemo.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Contact {
    @Id
    private ObjectId _id;

    private String name;
    private Integer age;
    private String email;

    public Contact() {
    }

    public Contact(ObjectId _id, String name, Integer age, String email) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":" + "\"" + name + "\"" +
                ", \"age\":" +  + age  +
                ", \"email\":\"" + email + '\"' +
                '}';
    }
}
