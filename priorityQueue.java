import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
 class StComparator implements Comparator<Student>
 {
     public int compare(Student a, Student b)
     {
          if(a.getCgpa() < b.getCgpa()){
            return 1;
        }
        else if(a.getCgpa() > b.getCgpa()){
            return -1;
        }
        else{
            if(a.getName().compareTo(b.getName()) < 0){
                return -1;
            }
            else if(a.getName().compareTo(b.getName()) > 0){
                return 1;
            }
            else{
                if(a.getId() < b.getId()){
                    return -1;
                }
                else{
                    return 1;
                }
                
            }
        }
     }
 }
 class Priorities extends PriorityQueue<Student>
 
 {
      
     List<Student> getStudents(List<String> events){
         PriorityQueue<Student> students = new PriorityQueue<Student>(events.size(), new StComparator());
        List<Student> st=new ArrayList<>();
         for(int i=0;i<events.size();i++)
         {
             
             if(events.get(i).equals("SERVED"))
             {
                students.poll();
                 
             }
             else{
                 String[] e=events.get(i).split(" ");
                 if(e[0].equals("ENTER"))
                 {
                     students.add(new Student(Integer.parseInt(e[3]),e[1],Double.parseDouble(e[2])));
                 }
             }
             
         }
         st.addAll(students);
         return st;
         
     }
 }
 class Student{
     int id;
     String name;
     double cgpa;
     Student(int id, String name,double cgpa)
     {
         this.id=id;
         this.name=name;
         this.cgpa=cgpa;
         
     }
     public String getName()
     {
         return name;
     }
     public int getId()
     {
         return id;
     }
     public double getCgpa()
     {
         return cgpa;
     }
 }


public class priorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}