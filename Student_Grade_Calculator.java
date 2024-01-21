import java.util.*;

public class Student_Grade_Calculator 
{
    Scanner S = new Scanner(System.in);
    int Physics, Chemistry, Biology, Maths;
    int total_marks = 0;
    double percent = 0; 

    public void getMarks() 
    {
        System.out.println("Enter the Marks of Physics:");
        Physics = S.nextInt();
        System.out.println("Enter the Marks of Chemistry:");
        Chemistry = S.nextInt();
        System.out.println("Enter the Marks of Biology:");
        Biology = S.nextInt();
        System.out.println("Enter the Marks of Maths:");
        Maths = S.nextInt();
    }

    public void Total_Marks() 
    {
        total_marks = Physics + Chemistry + Biology + Maths;
        System.out.println("The Total marks in the four Subjects are: " + total_marks);
    }

    public void Percentage() 
    {
        percent = ((double) total_marks / 400) * 100;
        System.out.println("The Total Percentage is: " + percent);
    }

    public void Grade() 
    {
        if (percent > 90) 
        {
           System.out.println("The Grade Obtained by the Student is: A");
        } 
        else if (percent > 80) 
        {
           System.out.println("The Grade Obtained by the Student is: B");
        } 
        else if (percent > 70) 
        {
           System.out.println("The Grade Obtained by the Student is: C");
        } 
        else 
        {
           System.out.println("The Grade Obtained by the Student is: F");
        }
    }

    public void Display_info()
    {
          System.out.println("Marks Obtain in 4 Subjects are :");
          System.out.println("Physics :"+Physics+"\nChemistry :"+Chemistry+"\nBiology :"+Biology+"\nMaths :"+Maths);
          System.out.println("Total Marks are :"+total_marks);
          System.out.println("Average Percentage are :"+percent);
          Grade();
    }

    public static void main(String arr[]) {
        Student_Grade_Calculator S = new Student_Grade_Calculator();

        S.getMarks();
        S.Total_Marks();
        S.Percentage();
        S.Display_info();
    }
}
