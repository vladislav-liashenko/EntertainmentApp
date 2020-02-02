package model;

public class Human {

    public String fullName;
    public int age;

    public Human(){}
    public Human(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;


    }
}
