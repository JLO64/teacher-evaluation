//Made by Julian Lopez

import java.util.*;

public class teacher_evaluation
{
  public static void main(String[] args)
  {
    List<evalEntry> teacherList = new ArrayList<evalEntry>();   //creation of an ArrayList of the evalEntry object
    
    createEntry(teacherList);

    printList(teacherList);
  }

  public static List<evalEntry> createEntry(List<evalEntry> teacherList)
  {
    System.out.println("What teacher do you want to evaluate?");
    Scanner scan = new Scanner(System.in);
    String teacherName = scan.nextLine();

    evalEntry entry = new evalEntry();		
    entry.nameChange(teacherName);
    teacherList.add(entry);    //adding the entry object to the ArrayList teacherList

    return teacherList;
  }

  public static void printList(List<evalEntry> teacherList)
  {
    for(evalEntry eval : teacherList)    //for-each list that traverses the ArrayList of the evalEntry object
			System.out.println(eval.getName());
			
		System.out.println(teacherList.get(0).getName());
  }
}

class evalEntry
{
  private String name;    //instance variable name that is created everytime the class evalEntry is created
  private double avgScore;

  public evalEntry()   //a constructor
  {
    name = "";
    avgScore = 0.0;
  }

  public evalEntry(String newName, double score)   //another constructor highlighting method overloading(same method names with different parameters)
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