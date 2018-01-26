import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // output welcome message
        System.out.println("Welcome to Derrick's World! ");

        // update welcome message with name
        Scanner readInput = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = readInput.next();
        System.out.printf("Hello %s\n", name);

        // initialize ArrayList
        ArrayList<Integer> absences = new ArrayList<>();
        //add random number of absences based on length of name
        for (int i = 0; i < name.length(); i++) {

            Random rand = new Random();
            int num = rand.nextInt(11);
            absences.add(num);
        }
        System.out.println("List of absences: " + absences);
        System.out.println("Students with perfect attendance: " + studentsWithPerfectAttends(absences));
        System.out.println("Average absences are: " + average(absences));
        System.out.println("Percentage of students with less than 3 absences and perfect attendance: " +
                lessThan3AbsencesAndPerfectAttendance(absences));
        System.out.printf("Number of absences? ");
        int num = readInput.nextInt();
        System.out.printf("Students with " + num + " absences: " + xAbsences(absences, num) + "\n");
        System.out.printf("Class meetings per week: ");
        num = readInput.nextInt();
        //System.out.printf("Formatted %d divided by %d is %.2f%%", num, num2, percentage);
        System.out.printf("%f students FE'd the course", percentageOfStudentsFE(absences));
        System.out.printf("Percentage of non-FE students: " + nonFEStudents(absences));

        //Collections.sort(absences);
    }

    private static double average(ArrayList<Integer> list) {
        return sumOfAbsences(list) / (double) list.size();
    }

    private static double sumOfAbsences(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }

    private static double studentsWithPerfectAttends(ArrayList<Integer> list) {
        double count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                count++;
            }
        }
        return count;
    }

    private static double lessThan3AbsencesAndPerfectAttendance(ArrayList<Integer> list) {
        int num = 3;
        double count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < num && list.get(i) == 0) {
                count++;
                count = count / list.size();
            }
        }
        return count;
    }

    private static ArrayList<Integer> xAbsences(ArrayList<Integer> list, int num) {
        ArrayList<Integer> numAbsences = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(num)) {
                numAbsences.add(i);
            }
        }
        return numAbsences;
    }

    private static double percentageOfStudentsFE(ArrayList<Integer> list) {
        ArrayList<Integer> feAbsences = new ArrayList<>();
        int num = 3;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= (num * 2)) {
                count++;
                feAbsences.add(i);
            }
        }
        return count;
    }

    private static double nonFEStudents(ArrayList<Integer> list) {
        int num = 0;
        double count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != percentageOfStudentsFE(list)) {
                count = count / list.size();
            }
        }
        return count;
    }

}
