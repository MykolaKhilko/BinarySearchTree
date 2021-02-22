package com.company;

public class Student {
    String name;
    String surname;
    int course;
    int ac_debt;

    public Student(String name, String surname, int course, int ac_debt){
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.ac_debt = ac_debt;
    }

    public static Student[] sortSelection(Student[] Students) {
        if (Students != null && Students.length > 1) {
            int swapIndex;
            Student temp;
            for (int index = 0; index < Students.length; index++) {
                String min = Students[index].surname;
                swapIndex = index;
                for (int sub = index + 1; sub < Students.length; sub++) {
                    if (min.compareTo(Students[sub].surname) > 0) {
                        min = Students[sub].surname;
                        swapIndex = sub;
                    }
                }
                if (swapIndex != index) {
                    temp = Students[index];
                    Students[index] = Students[swapIndex];
                    Students[swapIndex] = temp;
                }
            }
        }
        return Students;
    }

    public static int binarySearchB(Student[] Students, String key) {
        int index = -1;
        int low = 0;
        int high = Students.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (Students[mid].surname.compareTo(key)<0) {
                low = mid + 1;
            } else if (Students[mid].surname.compareTo(key)>0) {
                high = mid - 1;
            } else if (Students[mid].surname == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static Student[] delete(Student[] Students, int index){
        if(Students[index].ac_debt == 0 ) {
            for (int i = index; i < Students.length - 1; i++) {
                Students[i] = Students[i + 1];
            }
            Students[Students.length - 1] = new Student("", "", 0, 0);
            return Students;
        }
        else{
            return Students;
        }
    }

}
