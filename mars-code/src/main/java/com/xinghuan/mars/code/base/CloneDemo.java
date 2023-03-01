package com.xinghuan.mars.code.base;

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address();
        address.setStreet("1");
        Student student = new Student();
        student.setName("小王");
        student.setAge(18);
        student.setAddress(address);
        Student clone = (Student) student.clone();
        System.out.println(student == clone);
        student.setAge(20);
        student.getAddress().setStreet("2");
        System.out.println(student.getAddress().getStreet());
        System.out.println(clone.getAddress().getStreet());
    }

}

class Student implements Cloneable {

    private Integer age;

    private String name;

    private Address address;

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name=" + name +
                ", address=" + address +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Address {

    private String street;

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}
