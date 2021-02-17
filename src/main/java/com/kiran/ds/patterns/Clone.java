package com.kiran.ds.patterns;

public class Clone {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("kiran", new Course("Math"));
        System.out.println("Original:: Student: " + student.getName() + ", Course: " + student.getCourse().getName());
        Student cloneStudent = (Student) student.clone();
        cloneStudent.getCourse().setName("Science");
        System.out.println("Original:: Student: " + student.getName() + ", Course: " + student.getCourse().getName());
        System.out.println("   Clone:: Student: " + cloneStudent.getName() + ", Course: " + cloneStudent.getCourse().getName());
    }
}

class Student implements Cloneable {

    private String name;
    private Course course;

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        Course course = (Course) this.course.clone();
        student.setCourse(course);
        return student;
    }
}

class Course implements Cloneable {
    private String name;
    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

