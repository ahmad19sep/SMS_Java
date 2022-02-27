public class Student{
private static int count=0;
private String name;
private int stdClass;
private  int rollNo;
private int age;
private char gender;
 
 public Student(){
this.rollNo=++count;

 }
 public Student(String name, int stdClass, int rollNo, int age, char gender){
     this.name=name;
     this.stdClass=stdClass;
     this.rollNo=rollNo;
     
     this.age=age;
     this.gender=gender;
 }
 public void setName(String name){
     this.name=name;
 }
 public void setStdClass(int stdClass){
     this.stdClass=stdClass;
    
 }
 public void setRollNo(int rollNo){
     this.rollNo=rollNo;
    
 }
 public void setAge(int age){
     this.age=age;
 }
 public void setGender(char gender){
     this.gender=gender;
 }
 public String getName(){
     return name;
 }
 public int getStdClass(){
     return stdClass;
 }
 public int getRollNo(){
     return rollNo;
 }
 public int getAge(){
     return age;
 }
 public char getGender(){
     return gender;
 }

    public static int getCount(){
        return count;
    }


}