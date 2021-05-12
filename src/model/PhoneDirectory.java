package model;

import java.io.Serializable;

public class PhoneDirectory implements Serializable {
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String faceBook;

    public PhoneDirectory() {
    }

    public PhoneDirectory(String name, String phoneNumber, String address, String email, String faceBook) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.faceBook = faceBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaceBook() {
        return faceBook;
    }

    public void setFaceBook(String faceBook) {
        this.faceBook = faceBook;
    }

    @Override
    public String toString() {
        return "PhoneDirectory{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", faceBook='" + faceBook + '\'' +
                '}';
    }
}
