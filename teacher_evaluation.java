//Made by Julian Lopez

import java.io.*;
import java.util.*;

public class teacher_evaluation
{
  private String name;
  private double avgScore;

  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);

    System.out.println("What teacher do you want to evaluate?");
    String teacherName = scan.nextLine();

    teacher_evaluation cd = new teacher_evaluation(teacherName);

    System.out.println(cd.getName());   //the accessor getting the name

    List<teacher_evaluation> teacherList = new ArrayList<teacher_evaluation>();   //creation of a nArrayList of the teacher_evaluation object
    teacherList.add(cd);    //adding the cd object to the ArrayList teacherList

    for(teacher_evaluation eval : teacherList)    //for-each list that traverses the ArrayList of the teacher_evaluation object
      System.out.println(eval.getName());

  }

  public teacher_evaluation(String teachName)   //a constructor
  {
    name = teachName;
    avgScore = 0.0;
  }

  public String getName()   //an accesor
  {
    return name;
  }

}
