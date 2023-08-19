import java.util.*;
import java.io.*;

public class Client{

    private ArrayList<Student> students; // its the students arraylist
    boolean sorted = false;

    public Client() {
        students = new ArrayList<>();
    }

    public void loadStudents(String filename) throws FileNotFoundException { // throws Exception
        // this function loads students from a CSV file and adds them to the ArrayList
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] current_line = line.split(",");

            if (current_line[0].equals("C")) {
                students.add(new Student_Course(current_line[1], current_line[2], Long.parseLong(current_line[3]), current_line[4], Integer.parseInt(current_line[5]), Integer.parseInt(current_line[6]), Integer.parseInt(current_line[7]), Integer.parseInt(current_line[8])));
            } else if (current_line[0].equals("R")) {
                students.add(new Student_Research(current_line[1], current_line[2], Long.parseLong(current_line[3]), Integer.parseInt(current_line[5]), Integer.parseInt(current_line[6])));
            }
        }
    }

    public void printMenu() {
        System.out.println("1. Quit");
        System.out.println("2. Load students");
        System.out.println("3. Remove student");
        System.out.println("4. List students");
        System.out.println("5. Check Statistics");
        System.out.println("6. Report grade");
        System.out.println("7. Sort students");
        System.out.println("8. Output to CSV");
        System.out.println("9. Add student");
        System.out.println("Enter your choice: ");
    }

    public void run() throws Exception {
        // this function runs the main program
        // it should print the menu, read the user's choice, and call the appropriate function
        printMenu();
        int choice = Integer.parseInt(System.console().readLine());
        while (choice != 1) {
            switch (choice) {
                case 2:
                    System.out.println("Enter the filename: ");
                    String filename = System.console().readLine();
                    loadStudents(filename);
                    System.out.println("Successfully loaded students from " + filename);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter the student number: ");
                    int studentNumber = Integer.parseInt(System.console().readLine());
                    removeStudent(studentNumber);
                    break;
                case 4:
                    listStudents();
                    break;
                case 5:
                    int aboveAverage = 0;
                    int belowAverage = 0;
                    int num = 0;
                    int total = 0;
                    for (Student student : students) {
                        if (student instanceof Student_Course) {
                            total += student.getOverallMark();
                            num++;
                        }
                    }
                    int average = total / num;
                    System.out.println("Average: " + average);
                    for (Student student : students) {
                        if (student instanceof Student_Course) {
                            if (student.getOverallMark() >= average) {
                                aboveAverage++;
                            } else {
                                belowAverage++;
                            }
                        }
                    }
                    System.out.println("Above average: " + aboveAverage);
                    System.out.println("Below average: " + belowAverage);
                    break;
                case 6:
                    System.out.println("Enter the student number: ");
                    studentNumber = Integer.parseInt(System.console().readLine());
                    reportGrade(studentNumber);
                    break;
                case 7:
                    insertionSort(students);
                    sorted = true;
                    System.out.println("Successfully sorted students!");
                    listStudents();
                    break;
                case 8:
                    System.out.println("Enter the filename: ");
                    filename = System.console().readLine();
                    if (!sorted){
                        System.out.println("ArrayList not Sorted!");
                    }
                    else{
                        outputStudentsToCSVFile(filename);
                    }
                    break;
                case 9:
                    addStudent();
                    sorted = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            printMenu();
            choice = Integer.parseInt(System.console().readLine());
        }
    }

    private void insertionSort(ArrayList<Student> students) {
        // this function sorts the ArrayList of students using insertion sort
        for (int i = 1; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            int j = i - 1;
            while (j >= 0 && students.get(j).getStudentNumber() > currentStudent.getStudentNumber()) {
                students.set(j + 1, students.get(j));
                j--;
            }
            students.set(j + 1, currentStudent);
        }
    }

    private void removeStudent(int studentNumber) {
        // this function removes a student from the ArrayList
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber() == studentNumber) {
                System.out.println("Are you sure you want to remove " + students.get(i).getFirstName() + " " + students.get(i).getLastName() + "? (Y/N)");
                String choice = System.console().readLine();
                if (choice.equals("Y")) {
                    System.out.println("Successfully removed " + students.get(i).getFirstName() + " " + students.get(i).getLastName());
                    students.remove(i);
                } else {
                    System.out.println("Cancelled");
                }
                break;
            }
        }
    }

    private void addStudent() throws Exception {
        // this function adds a student to the ArrayList
        System.out.println("Enter the student's first name: ");
        String first_name = System.console().readLine();
        System.out.println("Enter the student's last name: ");
        String last_name = System.console().readLine();
        System.out.println("Enter the student's number: ");
        int studentNumber = Integer.parseInt(System.console().readLine());
        System.out.println("Enter the student's Unit ID: ");
        String unit_id = System.console().readLine();
        System.out.println("Enter the student's enrolment type (C or R): ");
        String enrolmentType = System.console().readLine();
        if (enrolmentType.equals("C")) {
            System.out.println("Enter student's level: ");
            int level = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the student's assignment 1 mark: ");
            int assignment1Mark = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the student's assignment 2 mark: ");
            int assignment2Mark = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the student's final exam mark: ");
            int finalExamMark = Integer.parseInt(System.console().readLine());
            students.add(new Student_Course(first_name, last_name, studentNumber, unit_id, level, assignment1Mark, assignment2Mark, finalExamMark));
        } else if (enrolmentType.equals("R")) {
            System.out.println("Enter the student's proposal mark: ");
            int proposalMark = Integer.parseInt(System.console().readLine());
            System.out.println("Enter the student's dissertation mark: ");
            int dissertationMark = Integer.parseInt(System.console().readLine());
            students.add(new Student_Research(first_name, last_name, studentNumber, proposalMark, dissertationMark));
        }
        System.out.println("Successfully Added!");

    }
    

    private void listStudents() {
        // this function lists all the students in the ArrayList
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }
    }

    private void reportGrade(int studentNumber) {
         // this function reports the grade of a student
        for (Student student : students) {
            if (student.getStudentNumber() == studentNumber) {
                System.out.println("Grade of " + student.getFirstName() + " " + student.getLastName() + ": ");
                student.reportGrade();
                break;
            }
        }
    }

    public void outputStudentsToCSVFile(String filename) throws Exception {
        // this function outputs the students to a CSV file
        FileWriter writer = new FileWriter(filename);
        for (Student student : students) {
            if (student instanceof Student_Course) {
                writer.write("C," + student.getFirstName() + "," + student.getLastName() + "," + student.getStudentNumber() + "," + student.getUnitID() + "," + student.getLevel() + "," + student.getAssignment1Mark() + "," + student.getAssignment2Mark() + "," + student.getFinalExamMark() + "," + student.getOverallMark() + "\n");
            } else if (student instanceof Student_Research) {
                writer.write("R," + student.getFirstName() + "," + student.getLastName() + "," + student.getStudentNumber() + "," + student.getProposalMark() + "," + student.getDissertationMark() + "," + student.getOverallMark() + "\n");
            }
        }
        writer.close();
    }
    

    public static void main(String[] args) throws Exception { // main function
        // this function creates a Client object and calls the run function
        Client client = new Client();
        client.run(); // run the program
    }
}