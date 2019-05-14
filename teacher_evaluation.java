
//Made by Julian Lopez

import java.io.*;
import java.math.*;
import java.util.*;

public class teacher_evaluation
{
  private static String studentName = "";
  private static List<String> questionList = new ArrayList<String>();

  public static void main(String[] args)
  {
    List<evalEntry> teacherList = new ArrayList<evalEntry>(); // creation of an ArrayList of the evalEntry object

    readFile();

    Scanner scan = new Scanner(System.in);
    System.out.print("What is your name? ");
    studentName = scan.nextLine();

    createEntry(teacherList);

    printList(teacherList);
  }

  public static List<evalEntry> createEntry(List<evalEntry> teacherList) // creation of an entry in the teacherList rrayList
  {
    evalEntry entry = new evalEntry();

    System.out.print("What teacher do you want to evaluate? ");
    Scanner scan = new Scanner(System.in);
    String teacherName = scan.nextLine();
    entry.teachNameChange(teacherName);

    System.out.print("What class does " + teacherName + " teach? ");
    String teacherClass = scan.nextLine();
		entry.teachClassChange(teacherClass);
		
		entry.askQuestions(questionList);

    teacherList.add(entry); // adding the entry object to the ArrayList teacherList
    return teacherList;
  }

	public static void printList(List<evalEntry> teacherList)
	{
    for (evalEntry eval : teacherList) // for-each list that traverses the ArrayList of the evalEntry object
      printTeachInfo(eval);
  }

	public static void printEntry(List<evalEntry> teacherList, int entryNum)
	{
    System.out.println(teacherList.get(entryNum).getTeachName());
  }

  public static String getStudentName() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return studentName;
  }

	public static void printTeachInfo(evalEntry entry)
	{
    System.out.println("\nStudent: " + getStudentName());
    System.out.println("Teacher: " + entry.getTeachName());
    System.out.println("Teacher Class: " + entry.getTeachClass());
    System.out.println("Teacher Average Score: " + entry.getTeachScore());
    System.out.println("Teacher Evaluation: " + entry.getTeachEval());
  }

  public static void readFile()
  {
    try
    {
      Scanner questionScan = new Scanner(new File("questions.txt"));
			while(questionScan.hasNextLine())
			{
				String line = questionScan.nextLine();
				questionList.add(line);
			}
    }
    catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      //e.printStackTrace();
    }    
  }
}

class evalEntry // represents a teacher
{
  private String teacherName; // instance variable teacherName that is created everytime the class evalEntry is created
  private String teacherClass;
	private double avgScore;
  private static List<String> responces = new ArrayList<String>();
  private String teacherEvaluation;

  public evalEntry() // a constructor
  {
    teacherName = "";
    teacherClass = "";
    avgScore = 0.0;
    teacherEvaluation = "";
  }

  public evalEntry(String newName, String teachClass, double score) // another constructor highlighting method overloading(same method names with different parameters)
  {
    teacherName = newName;
    avgScore = score;
    teacherClass = teachClass;
    teacherEvaluation = "";
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

  public String getTeachEval() // another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return teacherEvaluation;
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
  
  public void teachEvalChange(double score) // a mutator (changes instance variable values)
  {
    if(score < 1.0)
    {
      teacherEvaluation = "Fire him";
    }
    if(score >= 1.0)
    {
      teacherEvaluation = "Give him a raise";
    }
  }
	
	public void askQuestions(List<String> questionList)
	{
		System.out.println("\nPlease reply with either \"Agree\" or \"Disagree\"");
		for (String question : questionList)
		{
			System.out.print(question + " ");
			Scanner response = new Scanner(System.in);
			String responceLine = response.nextLine();
			responces.add(responceLine);
		}
		double countEntries = 0;
		double avgscore = 0;
		for (String input : responces)
		{
      countEntries++;
			if(input.equals("Agree"))
			{
        avgscore = avgscore + 1;
			}
			if(input.equals("Disagree"))
			{
				avgscore = avgscore + 0;
			}
    }
    avgscore = avgscore /countEntries;
    teachScoreChange(round(avgscore, 2));
    teachEvalChange(avgscore);
  }

  public static double round(double value, int places)
  {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}
