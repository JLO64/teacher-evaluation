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

    teacher_evaluation c = new teacher_evaluation(teacherName);

    System.out.println(c.getName());
  }

  public teacher_evaluation(String teachName)
  {
    name = teachName;
    //double avgScore = 0.0;
  }

  public String getName()
  {
    return name;
  }

}
