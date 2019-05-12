//Made by Julian Lopez

import java.util.*;

public class teacher_evaluation
{
  private static String studentName = "";
  
  public static void main(String[] args)
  {
    List<evalEntry> teacherList = new ArrayList<evalEntry>();   //creation of an ArrayList of the evalEntry object
    
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your name?");
    studentName = scan.nextLine();
    
    createEntry(teacherList);

    printList(teacherList);
  }

  public static List<evalEntry> createEntry(List<evalEntry> teacherList)
  {
    System.out.println("What teacher do you want to evaluate?");
    Scanner scan = new Scanner(System.in);
    String teacherName = scan.nextLine();

    evalEntry entry = new evalEntry();		
    entry.teachNameChange(teacherName);
    teacherList.add(entry);    //adding the entry object to the ArrayList teacherList

    return teacherList;
  }

  public static void printList(List<evalEntry> teacherList)
  {
    for(evalEntry eval : teacherList)    //for-each list that traverses the ArrayList of the evalEntry object
			System.out.println(eval.getTeachName());
  }

  public static void printEntry(List<evalEntry> teacherList, int entryNum) {
    System.out.println(teacherList.get(entryNum).getTeachName());
  }

  public String getStudentName()   //an accesor (doesn't change anything, only accesses instance variables)
  {
    return studentName;
  }
}

class evalEntry   //represents a teacher
{
  private String teacherName;   //instance variable teacherName that is created everytime the class evalEntry is created
  private String teacherClass;
  private double avgScore;

  public evalEntry()   //a constructor
  {
    teacherName = "";
    teacherClass = "";
    avgScore = 0.0;
  }

  public evalEntry(String newName, String teachClass, double score)   //another constructor highlighting method overloading(same method names with different parameters)
  {
    teacherName = newName;
    avgScore = score;
    teacherClass = teachClass;
  }
  
  public String getTeachName()   //an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherName;
  }

  public String getTeachClass()   //an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherClass;
  }
  
  public double getTeachScore()   //another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return avgScore;
  }
	
	public void teachNameChange(String newName)	//a mutator (changes instance variable values)
	{
		teacherName = newName;
  }

  public void teachClassChange(String newclass)	//a mutator (changes instance variable values)
	{
		teacherName = newclass;
  }
  
  public void teachScoreChange(double score)	//another mutator (changes the instance variable for the average score)
	{
		avgScore = score;
	}
}