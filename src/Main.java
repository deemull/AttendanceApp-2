import java.util.*;

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
                lessAbsencesAndPerfectAttendance(absences));
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
        System.out.println("New absences: " + absences);
        Collections.sort(absences);
        System.out.println(absences);
        Collections.shuffle(absences);
        System.out.println(absences);
        System.out.printf("The list has " + uniqueAbsences(absences) + " unique absences. ");
        System.out.printf("Each number of absences: " + eachAbsence(absences));
        System.out.printf("Sorted in ascending order: " + userSort(absences));
        System.out.printf("Shuffled list: " + userShuffle(absences));
        ArrayList<String> nameList = new ArrayList<>();
        System.out.printf("What is the name? ");
        String names = readInput.next();
        System.out.println(distinctNames(names, num));
        System.out.println(nameShuffle(nameList));
        System.out.println(sameSize(nameList));
        System.out.println(namesUsedOnce(nameList));


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

    private static double lessAbsencesAndPerfectAttendance(ArrayList<Integer> list) {
        int num = 3;
        double countLessThan = 0;
        double countPerfect = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < num) {
                countLessThan++;
            }
            if (list.get(i) == 0) {
                countPerfect++;
            }
        }
        return countLessThan / countPerfect;
    }

    private static ArrayList<Integer> xAbsences(ArrayList<Integer> list, int num) {
        ArrayList<Integer> numAbsences = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
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
            if (list.get(i) > 15) {
                list.set(i, 15);
            }
            if (list.get(i) < 0) {
                list.set(i, 0);
            }
        }
    }

    private static int uniqueAbsences(ArrayList<Integer> list) {
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static Map<ArrayList<Integer>, Integer> eachAbsence(ArrayList<Integer> list) {
        Collections.sort(list);
        Map<ArrayList<Integer>, Integer> numAbsences = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(i + 1)) {
                numAbsences.put(list, list.get(i));
            }
        }
        return numAbsences;
    }

    public static ArrayList<Integer> userSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(i) > list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> userShuffle(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                int swap = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swap);
            }
        }
        return list;
    }

    public static ArrayList<String> distinctNames(String name, int num) {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            names.add(name);
        }
        return names;
    }

    public static ArrayList<String> nameShuffle(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                String swap = list.get(i);
                list.set(i, list.get(j));
                list.set(j, swap);
            }
        }
        return list;
    }

    public static ArrayList<String> sameSize(ArrayList<String> names) {
        ArrayList<String> sameListSize = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            sameListSize.add(names.get(i));
        }
        return sameListSize;
    }

    public static boolean namesUsedOnce(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(names.get(i + 1))) {
                return true;
            }
        }
        return false;
    }
    /*public static ArrayList<String> perfectStudents(ArrayList<Integer> list, ArrayList<String> names) {

    }
    */

}
