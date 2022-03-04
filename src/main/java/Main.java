
import java.util.Scanner;

public class Main {

    static int index = 0;
    static int ARRAY_SIZE = 0;
    static Student[] students;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ARRAY_SIZE = Integer.parseInt(args[0]);
        students = new Student[ARRAY_SIZE];
        mainMenu();

        while (true) {
            searchSystemMain();

        }

    }

    //*************************************Main menu********************************************************************* */
    public static void mainMenu() {
        System.out.println("                        \"Student Record System\"");
        System.out.println("*****Main Menu*****");
        System.out.println("                           ");


    }


    public static void searchSystemMain() {
        while (true) {
            System.out.println("________________________________________________");
            System.out.println("To add new student record please press: 'n'");
            System.out.println("To search please press: 's'");
            System.out.println("To delete please press: 'd'");
            System.out.println("To view all students record press: 'a'");
            System.out.println("To exit please press: 'e'");
            System.out.println("To check how many students are present:press 't'");
            System.out.println("________________________________________________");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice please: ");
            char input = scanner.next().charAt(0);
            if (input == 'n' || input == 's' || input == 'd' || input == 'a' || input == 'e' || input == 't') {
                inputChecker(input);
                break;
            } else {
                System.out.println("Enter Valid input");
            }
        }
    }

    public static void inputChecker(char input) {

        flush();
        if (input == 'n') {
            addStudent();

        } else if (input == 's') {
            if (index > 0) {
                searchStudentData();
            } else {
                System.out.println("please add data first");
            }
        } else if (input == 'e') {

            exitFromProgram();


        } else if (input == 'd') {
            if (index > 0) {

                exitFromDeleteProgram();
            } else {
                System.out.println("please add data first");
            }
        } else if (input == 'a') {
            exitFromViewDataFunctionToMainMenu();

        } else if (input == 't') {
            tocheckTotalStudent();
        } else {

            System.out.print("Enter valid input: ");
        }
    }
    // Student add menu started------------------------------------------------------------------**********************
    //*********************************************************************************************************** */


    public static void addStudent() {

        while (true) {
            if (index < ARRAY_SIZE) {
                students[index] = new Student();
                System.out.println("----Adding a new student-----");
                addStudentName();
                addStudentClass();

                addStudentAge();
                addStudentGeneder();
                index++;
                System.out.println("________________________________________");

                char choice = addAnotherStudentChoiceReader();
                if (choice == 'm') {
                    break;
                }
            } else {
                System.out.println("No enough space to add more students....... ");
                break;
            }
        }
    }

    public static char addAnotherStudentChoiceReader() {
        while (true) {
            System.out.println("(:*****Student Added Successfully******:)");
            System.out.println("                            ");
            System.out.println("To Add Another Student press 'a'");
            System.out.println("Back to Main menu press 'm'");
            System.out.println("_____________________________________________");
            System.out.print("Enter your choice: ");
            char choice = scanner.next().charAt(0);
            if (choice == 'm' || choice == 'a') {
                return choice;
            } else {
                System.out.println("please give valid choice ('a' or 'm'");

            }
        }
    }

    public static void addStudentName() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = scanner1.nextLine();
        students[index].setName(name);
    }

    public static void addStudentClass() {
        while (true) {

            System.out.print("Enter Student Class: ");
            int stdClass = scanner.nextInt();
            scanner.nextLine();
            if (stdClass >= 1 && stdClass < 17) {
                students[index].setStdClass(stdClass);
                break;
            } else {
                System.out.println("Please enter  in the range(1-16) (:-Thanks-:)");
            }
        }
    }


    public static void addStudentAge() {
        while (true) {
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            if (age >= 5 && age <= 30) {

                scanner.nextLine();
                students[index].setAge(age);
                break;
            } else {
                System.out.println("Please enter  in the range(5-30) (:-Thanks-:)");

            }
        }
    }

    public static void addStudentGeneder() {
        while (true) {
            System.out.print("Enter Student Gender: ");
            char gender = scanner.next().charAt(0);
            if (gender == 'm' || gender == 'f') {
                students[index].setGender(gender);
                scanner.nextLine();
                break;
            } else {
                System.out.println("Please enter  correct gender (:-Thanks-:)");

            }
        }
    }

    //****************************************Add student Menu ended***************************************************** */

    //exit from program ------------------------------------------------------------------------------------------flush
    //-------------------------------------------------------------------------------------------------------------------
    public static void flush() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("");

        }
    }

    public static void exitFromProgram() {
        System.exit(0);
    }


    // Search System Start*****************************************************Search System Start*****************//
    //----------------------------------------------------------------------------------------------------------
    public static void searchStudentData() {
        System.out.println("--------------------------------");
        System.out.println("           Search Student");
        while (true) {
            readChoiceForSearchStudent();
            System.out.println("_____________________________");
            char choice = searchToMainMenu();
            if (choice == 'm') {
                break;
            }
        }


    }

    public static void searchStudentMenu() {
        System.out.println("To Search by Name Press: 'n'");
        System.out.println("To Search by Age Press: 'a'");
        System.out.println("To Search by Class Press: 'c'");
        System.out.println("To Search by RollNo Press: 'r'");
        System.out.println("______________________________________");


    }

    public static void readChoiceForSearchStudent() {
        while (true) {
            searchStudentMenu();
            System.out.print("Enter Your Choice Please: ");
            char read = scanner.next().charAt(0);
            if (read == 'n') {
                searchByName();
                break;
            } else if (read == 'a') {
                System.out.println("     ");
                searchByAge();
                break;
            } else if (read == 'c') {
                System.out.println("   ");
                searchByClass();
                break;
            } else if (read == 'r') {
                System.out.println("   ");
                searchByRollNo();
                break;
            } else {
                System.out.println("Enter valid option:");
            }
        }
    }

    public static void searchByName() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String enteredName = scanner1.nextLine();
        boolean isFound = false;
        for (int i = 0; i < index; i++) {

            if (enteredName.equals(students[i].getName())) {

                displaySearchResults(i);
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("NO RESULTS FOUND ");
        }
    }


    public static void displaySearchResults(int Index) {
        System.out.println("---------------------------");
        System.out.println("Student Name: " + students[Index].getName());
        System.out.println("Student Age: " + students[Index].getAge());
        System.out.println("Student Class: " + students[Index].getStdClass());
        System.out.println("Student RollNo: " + students[Index].getRollNo());
        // System.out.println("Student Gender: "+students[Index].getGender());
        if ('m' == students[Index].getGender()) {
            System.out.println("Student Gender: male");
        } else if (students[Index].getGender() == 'f') {
            System.out.println("Student Gender: female");
        }
    }

    public static void searchByAge() {
        while (true) {
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            if (age > 5 && age < 31) {
                int conditionIfElse = 0;
                for (int i = 0; i < index; i++) {
                    if (age == students[i].getAge()) {
                        displaySearchResults(i);
                        conditionIfElse++;
                    }
                }
                if (conditionIfElse == 0) {
                    System.out.println("NO RESULTS FOUND ");
                    break;
                }
                break;
            } else {
                System.out.println("Please enter Age in the range: ");
            }
        }
    }

    public static void searchByClass() {
        while (true) {
            System.out.print("Enter Student Class: ");
            int enteredClass = scanner.nextInt();
            scanner.nextLine();
            if (enteredClass >= 1 && enteredClass <= 16) {
                int conditionIfElse = 0;
                for (int i = 0; i < index; i++) {
                    if (enteredClass == students[i].getStdClass()) {
                        displaySearchResults(i);
                        conditionIfElse++;

                    }
                }
                if (conditionIfElse == 0) {
                    System.out.println("NO RESULTS FOUND ");
                    break;
                }
                break;

            } else {
                System.out.println("Please enter Class in the range(5-16): ");
            }
        }
    }


    public static void searchByRollNo() {
        while (true) {
            System.out.print("Enter Student RollNo: ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            if (roll >= 1 && roll <= 100) {
                int conditionIfElse = 0;
                for (int i = 0; i < index; i++) {
                    if (roll == students[i].getRollNo()) {
                        displaySearchResults(i);
                        conditionIfElse++;

                    }
                }
                if (conditionIfElse == 0) {
                    System.out.println("NO RESULTS FOUND ");
                    break;
                }
                break;
            } else {
                System.out.println("Please enter rollNo in the range 1-100: ");
            }
        }
    }

    public static char searchToMainMenu() {
        while (true) {
            System.out.println("    ");
            System.out.println("To Search More Data Press: 's");
            System.out.println("Back to MainMenu press: 'm");
            System.out.println("---------------------------------");
            System.out.print("Enter Your choice:  ");
            char choice = scanner.next().charAt(0);
            if (choice == 'm' || choice == 's') {
                return choice;
            } else {
                System.out.print("Enter valid option: ");


            }

        }
    }

    // Search sytem ended ***************************************************************
    //******************************************************************************** */
    //********************************************************************************* */

    public static void deleteSystemDisplayMenu() {
        System.out.println("          Welcome in Delete Student Data  System");
        System.out.println("********Menu********");
        System.out.println("Delete By RollNo Press: 'r'");
        System.out.println("_________________________________________________");

    }

    public static void inputReaderFromDeleteSystemDisplayMenu() {
        while (true) {
            deleteSystemDisplayMenu();
            System.out.print("Enter Your Choice: ");
            char deleteSystemInput = scanner.next().charAt(0);
            if (deleteSystemInput == 'r') {
                flush();
                deleteByRollNo();
                break;
            } else {
                System.out.println("Enter Valid input Please");
            }
        }
    }


    public static void deleteByRollNo() {
        while (true) {
            System.out.print("Enter Student RollNo: ");
            int RollNo = scanner.nextInt();
            scanner.nextLine();
            if (RollNo > 0 && RollNo <= 100) {
                int forBreaker = 0;
                for (int i = 0; i < index; i++) {
                    if (RollNo == students[i].getRollNo()) {
                        students[i] = students[index - 1];
                        students[index] = null;
                        index--;
                        forBreaker++;

                    }
                }

                if (forBreaker == 0) {
                    System.out.println("No results found");
                }
                break;
            } else {
                System.out.println("Enter Valid Input: ");

            }

        }
    }


    public static char subFunctionOfExitFromDeleteProgram() {
        while (true) {
            System.out.println("..........Deleted successfully.......");
            System.out.println("-------------------------------");
            System.out.println("    ");
            System.out.println("To  Another Student Data Press: 'd'");
            System.out.println("Back to MainMenu press: 'm");
            System.out.println("---------------------------------");
            System.out.print("Enter Your choice:  ");
            char choice = scanner.next().charAt(0);
            if (choice == 'm' || choice == 'd') {
                return choice;
            } else {
                System.out.print("Enter valid option: ");


            }

        }
    }

    public static void exitFromDeleteProgram() {
        while (true) {
            inputReaderFromDeleteSystemDisplayMenu();
            char choice = subFunctionOfExitFromDeleteProgram();
            if (choice == 'm') {
                break;
            }
        }
    }

    //*********************************************************************************************** */
//__________________View all students
    public static void toViewAllDataDisplayMenu() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("YOU REALLY WANT TO CHECK ALL DATA PRESS 'yes' : ");
        String viewDATA = scanner1.nextLine();
        while (true) {
            if (viewDATA.equals("yes")) {
                if (index != 0) {
                    for (int i = 0; i < index; i++) {
                        System.out.println(" ");
                        int list = i + 1;
                        System.out.println(" ");
                        System.out.println(" *********NO:" + list + "*********");
                        System.out.println("---------------------------");
                        System.out.println("Student Name: " + students[i].getName());
                        System.out.println("Student Age: " + students[i].getAge());
                        System.out.println("Student Class: " + students[i].getStdClass());
                        System.out.println("Student RollNo: " + students[i].getRollNo());
                        if (students[i].getGender() == 'm') {
                            System.out.println("Student Gender:male");
                        } else if (students[i].getGender() == 'f') {
                            System.out.println("Student Gender: female");
                        }
                    }
                } else {
                    System.out.println("DATA NOT FOUND THANKS");
                }
                break;
            } else {
                System.out.println("Enter valid input please: ");
            }
        }

    }

    public static char subFunctionOfExitFromViewDataFunctionToMainMenu() {
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("Press 'a' To View  Data Again: ");
            System.out.println("Press 'm' To MainMenu: ");
            System.out.println("________________________________");
            System.out.print("Enter Your Choice: ");
            char choice = scanner.next().charAt(0);
            scanner.nextLine();
            if (choice == 'm' || choice == 'a') {
                return choice;
            } else {
                System.out.println("Enter valid input");
            }
        }
    }

    public static void exitFromViewDataFunctionToMainMenu() {
        while (true) {
            toViewAllDataDisplayMenu();
            System.out.println(" ");
            char choice = subFunctionOfExitFromViewDataFunctionToMainMenu();
            if (choice == 'm') {
                break;
            }

        }
    }

    //*************************To Check Total Student***************************************** */
    public static void tocheckTotalStudent() {
        System.out.println("Only " + Student.getCount() + " students are presents!");
    }
}




