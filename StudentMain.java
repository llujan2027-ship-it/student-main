/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmain;

/**
 *
 * @author llujan2027
 */
//public class

import java.util.Scanner;
public class StudentMain{
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        boolean programRun = true;
        
        System.out.println("Hello. Welcome to your student grade calculator.");
        
        while(programRun == true){
            System.out.println("Please enter student's first name.");
            String name1 = scan.next();
            if("".equals(name1)){
                name1 = scan.nextLine();
            }
            System.out.println("Please enter student's last name.");
            String name2 = scan.next();
            if("".equals(name2)){
                name2 = scan.nextLine();
            }
            
            System.out.println("Now for their courses.");
            
            System.out.println("Please enter student's first course name.");
            String course1Name = scan.nextLine();
            //Failsafes
            if("".equals(course1Name)){
                course1Name = scan.nextLine();
            }
            System.out.println("Please enter student's first course grade.");
            double course1Test = scan.nextDouble();
            if("".equals(course1Test)){
                course1Test = scan.nextDouble();
            }
            Course course1 = new Course(course1Test, course1Name);

            System.out.println("Please enter student's second course name.");
            String course2Name = scan.nextLine();
            if("".equals(course2Name)){
                course2Name = scan.nextLine();
            }
            System.out.println("Please enter student's second course grade.");
            double course2Test = scan.nextDouble();
            if("".equals(course2Test)){
                course2Test = scan.nextDouble();
            }
            Course course2 = new Course(course2Test, course2Name);

            System.out.println("Please enter student's third course name.");
            String course3Name = scan.nextLine();
            if("".equals(course3Name)){
                course3Name = scan.nextLine();
            }
            System.out.println("Please enter student's third course grade.");
            double course3Test = scan.nextDouble();
            if("".equals(course3Test)){
                course3Test = scan.nextDouble();
            }
            Course course3 = new Course(course3Test, course3Name);


            Student student = new Student(name1, name2, course1, course2, course3);

            System.out.println("\n" + student);
            
            System.out.println("Input another student? y/n");
            boolean loopAsk = false;
            String input;
            do{
                loopAsk = false;
                input = scan.next();
                if(null == input){
                    System.out.println("Invalid input, please try again.");
                    loopAsk = true;
                }else switch (input) {
                    case "y" -> System.out.println("\n");
                    case "n" -> {
                        System.out.println("Thank you.");
                        programRun = false;
                    }
                    default -> {
                        System.out.println("Invalid input, please try again.");
                        loopAsk = true;
                    }
                }
            }while(loopAsk==true);
        }
    }
}

//basic class Student - should have 3 courses
class Student{    
    private String firstName, lastName;
    private Course course1;
    private Course course2;
    private Course course3;
    //int s = c1.setScore(85);
    
    //empty constructor to create empty Student object
    public Student(){
        firstName = "";
        lastName = "";
        course1 = new Course();
        course2 = new Course();
        course3 = new Course();
    }
    
    //basic constructor to create Student object with name only
    public Student(String first, String last){
        firstName = first;
        lastName = last;
        course1 = new Course();
        course2 = new Course();
        course3 = new Course();
    }
    
    //needs a constructor to include 3 course objects
    public Student(String first, String last, Course c1, Course c2, Course c3){
        firstName = first;
        lastName = last;
        course1 = c1;
        course2 = c2;
        course3 = c3;
    }
    
    public static double getAverage(Course c1, Course c2, Course c3){
        double average = 0;
        
        double sum = (c1.getTestScore() + c2.getTestScore() + c3.getTestScore());
        average = (sum/3);
        average = roundAvoid(average, 2);
        
        return average;
    }
    
    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    
    //basic toString code
    @Override
    public String toString(){
        String result;
        result = firstName + " " + lastName + ":\n"
                + course1.getCourseName() + ": - " + course1.getTestScore() + "%\n"
                + course2.getCourseName() + ": - " + course2.getTestScore() + "%\n"
                + course3.getCourseName() + ": - " + course3.getTestScore() + "%\n"
                + "Class average: " + Student.getAverage(course1, course2, course3) + "%\n";
        return result;
    }
}

//basic class Course
class Course{
    public double testScore;
    public String courseName;
    
    public Course(){
        testScore = 0;
        courseName = "";
    }
    
    public Course(double score, String name){
        testScore = score;
        courseName = name;
    }
    
    public double setTestScore(int inScore){
        testScore = inScore;
        return testScore;
    }
    
    public double getTestScore(){
        return testScore;
    }
    
    public String setCourseName(String inName){
        courseName = inName;
        return courseName;
    }
    
    public String getCourseName(){
        return courseName;
    }
}