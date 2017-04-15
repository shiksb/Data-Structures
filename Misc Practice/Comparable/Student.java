package com.Comparable;

/**
 * Created by shikhar on 3/6/17.
 */
public class Student implements Comparable<Student>{

    private int marks;

    public Student(int marks){
        this.marks = marks;
    }

    public static Student findMax(Student[] students){
        Student stud = new Student(0);
        for(Student s : students){
            if(s.compareTo(stud) > 0){
                stud.marks = s.marks;
            }
        }
        return stud;
    }

    public int compareTo(Student st){
        if(this.marks > st.marks) {
            return 1;
        } else if(this.marks < st.marks) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        Student[] Class = {
            new Student(3),
            new Student(4),
            new Student(6),
            new Student(10),
        };

        System.out.print(findMax(Class).marks);
    }
}
