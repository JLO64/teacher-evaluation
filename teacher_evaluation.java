//Made by Julian Lopez

import java.io.*;
import java.math.*;
import java.util.*;

public class teacher_evaluation {
  private static String teacherName;
  private static String teacherClass;
  private static List<String> questionList = new ArrayList<String>();
  private static List<evalEntry> teacherList = new ArrayList<evalEntry>(); // creation of an ArrayList of the evalEntry object

  public static void main(String[] args) {
    readFile();

    teachNameChange();
    teachClassChange();
    
    createEntry(teacherList);

    printList();

    exportInfo();
  }

  public static List<evalEntry> createEntry(List<evalEntry> teacherList) // creation of an entry in the teacherList arrayList
  {
    evalEntry entry = new evalEntry();

    entry.studentNameChange();

		entry.askQuestions(questionList);
		System.out.println();

    teacherList.add(entry); // adding the entry object to the ArrayList teacherList

    askContinue(teacherList);

    return teacherList;
  }

	public static void printList()
	{
    for (evalEntry eval : teacherList) // for-each list that traverses the ArrayList of the evalEntry object
      printTeachInfo(eval);
  }  

	public static void printTeachInfo(evalEntry entry)
	{
    System.out.println("\nStudent: " + entry.getStudentName());
    System.out.println("Teacher: " + getTeachName());
    System.out.println("Teacher Class: " + getTeachClass());
    System.out.println("Teacher Average Score: " + entry.getTeachScore());
    System.out.println("Teacher Evaluation: " + entry.getTeachEval());
    entry.printResponses(questionList);
	}

  public static void readFile()
  {
		try
		{
      Scanner questionScan = new Scanner(new File("questions.txt"));
      while (questionScan.hasNextLine()) {
        String line = questionScan.nextLine();
        questionList.add(line);
      }
		}
		catch (FileNotFoundException e)
		{
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
  }

	public static void exportInfo()
	{
    try
    {
			PrintStream textF = new PrintStream(new File("student_responces.txt"));
			System.setOut(textF);

    	printList();
		}
		catch (FileNotFoundException e)
		{
      // TODO Auto-generated catch block
      //e.printStackTrace();
    }    
  }

  public static String getTeachName() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherName;
  }

  public static String getTeachClass() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return teacherClass;
  }

  public static void teachNameChange(String newName) // a mutator (changes instance variable values)
  {
    teacherName = newName;
  }

  public static void teachClassChange(String newclass) // a mutator (changes instance variable values)
  {
    teacherClass = newclass;
  }

  public static void teachNameChange()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("What is the name of the teacher being evaluated? ");
    teacherName = scan.nextLine();
  }

  public static void teachClassChange()
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("What is the class that " + teacherName + " teaches? ");
    teacherClass = scan.nextLine();
  }

  public static List<evalEntry> askContinue(List<evalEntry> teacherList)
	{
    System.out.print("Do you want to add another student responce? ");
    Scanner scan = new Scanner(System.in);
    String yesNo = scan.nextLine();
    if(yesNo.equals("yes") || yesNo.equals("Yes"))
    {
      createEntry(teacherList);
      return teacherList;
    }
    else
    {
      return teacherList;
    }
  }  
}

class evalEntry // represents a student's responce
{
	private double avgScore; // instance variable teacherName that is created everytime the class evalEntry is created
  private static List<String> responces = new ArrayList<String>();
  private String teacherEvaluation;
  private static String studentName = "";

  public evalEntry() // a constructor
  {
    avgScore = 0.0;
    teacherEvaluation = "";
  }

  public evalEntry(double score) // another constructor highlighting method overloading(same method names with different parameters)
  {
    avgScore = score;
    teacherEvaluation = "";
  }

  public double getTeachScore() // another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return avgScore;
  }

  public String getTeachEval() // another accesor (doesn't change anything, only accesses the instance variable for the score)
  {
    return teacherEvaluation;
  }

  public void teachScoreChange(double score) // another mutator (changes the instance variable for the average score)
  {
    avgScore = score;
  }
  
  public void teachEvalChange(double score) // a mutator (changes instance variable values)
  {
    if(score == 1.0)
    {
      teacherEvaluation = "Give him a raise";
    }
    if(score < 1.0)
    {
      teacherEvaluation = "Not a bad teacher";
    }
    if(score == 0.0)
    {
      teacherEvaluation = "Fire him";
    }    
  }

  public String getStudentName() // an accesor (doesn't change anything, only accesses instance variables)
  {
    return studentName;
  }

  public void studentNameChange() // an accesor (doesn't change anything, only accesses instance variables)
  {
    System.out.print("\nWhat is the name of the student filling out this form? ");
    Scanner scan = new Scanner(System.in);
    studentName = scan.nextLine();
  }
	
	public void askQuestions(List<String> questionList)
	{
		System.out.println("Please reply with either \"Agree\" or \"Disagree\"");
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
			if(input.equals("Agree") || input.equals("agree"))
			{
        avgscore = avgscore + 1;
			}
			if(input.equals("Disagree") || input.equals("disagree"))
			{
				avgscore = avgscore + 0;
			}
    }
    avgscore = avgscore /countEntries;
    teachScoreChange(round(avgscore, 2));
    teachEvalChange(avgscore);
  }

  public void printResponses(List<String> questionList)
	{
    int i = 0;
    for (String question : questionList)
		{
      System.out.println(question + " " + responces.get(i));
      i++;
		}
  }

  public static double round(double value, int places)
  {
    if (places < 0) throw new IllegalArgumentException();

    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}
