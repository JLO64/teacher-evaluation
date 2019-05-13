
//Made by Julian Lopez

import java.io.*;
import java.util.*;

public class teacher_evaluation {
  private static String studentName = "";
  List<String> questionList = new ArrayList<String>();

  public static void main(String[] args) {
    List<evalEntry> teacherList = new ArrayList<evalEntry>(); // creation of an ArrayList of the evalEntry object

    Scanner scan = new Scanner(System.in);
    System.out.println("What is your name?");
    studentName = scan.nextLine();

    createEntry(teacherList);

    printList(teacherList);

    readFile();
  }

  public static List<evalEntry> createEntry(List<evalEntry> teacherList) // creation of an entry in the teacherList rrayList
  {
    evalEntry entry = new evalEntry();

    System.out.println("What teacher do you want to evaluate?");
    Scanner scan = new Scanner(System.in);
    String teacherName = scan.nextLine();
    entry.teachNameChange(teacherName);

    System.out.println("What class does " + teacherName + " teach?");
    String teacherClass = scan.nextLine();
    entry.teachClassChange(teacherClass);

    teacherList.add(entry); // adding the entry object to the ArrayList teacherList
    return teacherList;
  }

  public static void printList(List<evalEntry> teacherList) {
    for (evalEntry eval : teacherList) // for-each list that traverses the ArrayList of the evalEntry object
      printTeachInfo(eval);
  }

  public static void printEntry(List<evalEntry> teacherList, int entryNum) {
    System.out.println(teacherList.get(entryNum).getTeachName());
  }

  public static String getStudentName() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return studentName;
  }

  public static void printTeachInfo(evalEntry entry) {
    System.out.println("\nStudent: " + getStudentName());
    System.out.println("Teacher: " + entry.getTeachName());
    System.out.println("Class: " + entry.getTeachClass());
    System.out.println("Teacher's Average Score: " + entry.getTeachScore());
  }

  public static void readFile()
  {
    List<String> questionList = new ArrayList<String>();
    
    try
    {
      Scanner fileIn = new Scanner(new File("questions.txt"));
      while(fileIn.hasNextLine())
      {
        System.out.println(fileIn.nextLine());
        questionList.add(fileIn.nextLine());
      }
    }
    catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }    
  }
}

class evalEntry // represents a teacher
{
  private String teacherName; // instance variable teacherName that is created everytime the class evalEntry is created
  private String teacherClass;
  private double avgScore;

  public evalEntry() // a constructor
  {
    teacherName = "";
    teacherClass = "";
    avgScore = 0.0;
  }

  public evalEntry(String newName, String teachClass, double score) // another constructor highlighting method overloading(same method names with different parameters)
  {
    teacherName = newName;
    avgScore = score;
    teacherClass = teachClass;
  }

  public String getTeachName() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherName;
  }

  public String getTeachClass() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherClass;
  }

  public double getTeachScore() // another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return avgScore;
  }

  public void teachNameChange(String newName) // a mutator (changes instance variable values)
  {
    teacherName = newName;
  }

  public void teachClassChange(String newclass) // a mutator (changes instance variable values)
  {
    teacherClass = newclass;
  }

  public void teachScoreChange(double score) // another mutator (changes the instance variable for the average score)
  {
    avgScore = score;
  }
}

class evalSheet // represents the sheet to fillout
{
  
  List<String> answerList = new ArrayList<String>();

  
}