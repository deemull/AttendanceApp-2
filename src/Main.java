import java.util.ArrayList;
import java.util.Collections;
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
        System.out.printf(percentageOfStudentsFE(absences) + " of students FE'd the course ");
        System.out.printf("\n%.2f Percent of non-FE students: ", nonFEAbsences(absences));
        System.out.printf("\nAdd how many to absences? ");
        int add = readInput.nextInt();
        System.out.printf("To numbers greater than: ");
        num = readInput.nextInt();
        newAbsences(absences, num, add);
        Collections.sort(absences);
        System.out.println(absences);
        Collections.shuffle(absences);
        System.out.println(absences);
        System.out.printf("\nThe list has " + uniqueAbsences(absences) + " unique absences. ");

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

    private static int studentsWithPerfectAttends(ArrayList<Integer> list) {
        int count = 0;
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
                count = (count / list.size()) * 100;
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
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= (num * 2)) {
                feAbsences.add(i);
            }
        }
        return ((double) feAbsences.size() / list.size()) * 100;
    }

    private static double nonFEAbsences(ArrayList<Integer> list) {
        ArrayList<Integer> nonFeAbsences = new ArrayList<>();
        int num = 3;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < (num * 2)) {
                nonFeAbsences.add(i);
            }
        }
        return (double) nonFeAbsences.size() / list.size();
    }

    private static void newAbsences(ArrayList<Integer> list, int num, int add) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > num) {
                list.set(i, list.get(i) + add);
            }
        }
        System.out.println(list);
    }

    private static int uniqueAbsences(ArrayList<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }

}
