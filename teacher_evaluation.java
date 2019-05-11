//Made by Julian Lopez

import java.io.*;
import java.util.*;

public class teacher_evaluation
{
  public static void main(String[] args)
  {
		Scanner scan = new Scanner(System.in);

    System.out.println("What teacher do you want to evaluate?");
    String teacherName = scan.nextLine();

		evaluation cd = new evaluation();
		
		cd.nameChange(teacherName);

    System.out.println(cd.getName());   //the accessor getting the name

    List<evaluation> teacherList = new ArrayList<evaluation>();   //creation of a nArrayList of the evaluation object
    teacherList.add(cd);    //adding the cd object to the ArrayList teacherList

    for(evaluation eval : teacherList)    //for-each list that traverses the ArrayList of the evaluation object
			System.out.println(eval.getName());
			
		System.out.println(teacherList.get(0).getName());

  }

}
class evaluation
{
  private String name;    //instance variable name that is created everytime the class evaluation is created
  private double avgScore;

  public evaluation()   //a constructor
  {
    name = "";
    avgScore = 0.0;
  }

  public evaluation(String newName, double score)   //another constructor highlighting method overloading(same method names with different parameters)
  {
    name = newName;
    avgScore = score;
  }
  
  public String getName()   //an accesor (doesn't change anything, only accesses instance variables)
  {
    return name;
  }
  
  public double getScore()   //another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return avgScore;
  }
	
	public void nameChange(String newName)	//a mutator (changes instance variable values)
	{
		name = newName;
  }
  
  public void scoreChange(double score)	//another mutator (changes the instance variable for the average score)
	{
		avgScore = score;
	}
}