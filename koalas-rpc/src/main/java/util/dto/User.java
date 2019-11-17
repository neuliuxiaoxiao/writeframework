package util.dto;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private Integer integer;
    private String address;

    public User(String name, Integer integer, String address) {
        this.name = name;
        this.integer = integer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}