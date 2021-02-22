package com.company;

public class Main {
    static Student Students[];
    static Student SortedStudents[];
    static Student NewStudents[];

    private static void ShowStudents(Student[] Students){
        for (int i = 0; i < Students.length; i++){
            System.out.println((i + 1) + ". " + Students[i].name + " " + Students[i].surname + " "
                    + Students[i].course + " " + Students[i].ac_debt);
        }
    }

    private static void ShowNode(Node node){
        if(node != null){
            System.out.println(node.Data.surname + " " + node.Data.ac_debt);
        }
        else if(node == null){
            System.out.println ("Елемент не знайдено" );
        }
    }

    public static void main(String[] args) {
        Students = new Student[21];

        Students[0] = new Student("Vlados", "Sis", 1, 1);
        Students[1] = new Student("Vitos", "Ters", 2, 2);
        Students[2] = new Student("Sanchez", "Sokam",3, 3);
        Students[3] = new Student("Alex", "Kishnik",4, 1);
        Students[4] = new Student("Nick", "Triffle",5, 0);
        Students[5] = new Student("Maxon", "Legdrakee",1, 3);
        Students[6] = new Student("Nikitok", "Kotikin",2, 1);
        Students[7] = new Student("Dick", "Dickenson",3, 0);
        Students[8] = new Student("Alexa", "Red",4, 2);
        Students[9] = new Student("Anita", "Onish",5, 2);
        Students[10] = new Student("Sasha", "Kudryasha",1, 2);
        Students[11] = new Student("Max", "Kopach",2, 0);
        Students[12] = new Student("Dru", "Abramovich",3, 0);
        Students[13] = new Student("Denis", "Benis",4, 0);
        Students[14] = new Student("Lusia", "Polishuk",5, 1);
        Students[15] = new Student("Tim", "Web",1, 3);
        Students[16] = new Student("Max", "Bubun",2, 1);
        Students[17] = new Student("Katie", "Matvey",3, 0);
        Students[18] = new Student("Kris", "Chumak",4, 0);
        Students[19] = new Student("Alina", "Da Videnko",5, 0);
        Students[20] = new Student("Nastia", "Grish",1, 0);

        System.out.println("Несортований список студентів");
        ShowStudents(Students);
        System.out.println(" ");

        SortedStudents = Student.sortSelection(Students);
        System.out.println("Список студентів після сортування по прізвищу");
        ShowStudents(SortedStudents);
        System.out.println(" ");

        int i = Student.binarySearchB(SortedStudents, "Dickenson");
        System.out.println("Результати пошуку по прізвищу: "+ " " + i + ". "
                + SortedStudents[i].surname + " " + SortedStudents[i].ac_debt);
        System.out.println(" ");
        NewStudents =  Student.delete(SortedStudents, i);
        System.out.println("Ініціалізація видалення студенту зі списку якщо він немає академічних заборгованностей");
        System.out.println("Список студентів після видалення студента");
        ShowStudents(NewStudents);
        System.out.println(" ");

        BSTRee BST = new BSTRee();
        for(int l = 0; l < SortedStudents.length; l++){
            BST.insert(SortedStudents[l]);
        }

        System.out.println("Дерево бінарного пошуку");
        BST.traverse(BST.Root);
        System.out.println(" ");

        Node NewNode = BST.search(BST.Root, 3);
        System.out.println("Перший знайдений елемент з відповідним ключем");
        ShowNode(NewNode);
    }
}
