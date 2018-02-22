import java.time.LocalDate;
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
        ArrayList<String> date = new ArrayList<>();
        System.out.printf("What is the name? ");
        String names = readInput.next();
        System.out.println(distinctNames(names, num));
        System.out.println(nameShuffle(nameList));
        System.out.println(sameSize(absences, nameList));
        System.out.println(namesUsedOnce(nameList));
        System.out.println(perfectStudents(absences, nameList));
        System.out.println(studentsFE(absences, nameList));
        System.out.println(numOfClasses(absences, nameList));
        //System.out.println(FEcourses(absences, nameList));
        System.out.println(localDate());
        //System.out.println(daysAlive(date, ));
        //System.out.println(listOfDates(date, ));

        Record xavier = new Record();
        System.out.println(xavier);
        xavier.setDate(xavier.getDate().minusDays(10));
        xavier.setNumAbsences(xavier.getName().length());
        Record student = new Record("Derrick", 2, LocalDate.now());
        Record derrick = new Record("derrick", 1, LocalDate.of(1996, 10, 2));
        Record nonDefault = new Record("Winston", 0, LocalDate.of(1957, 11, 28));
        String swap = student.getName();
        student.setName(nonDefault.getName());
        nonDefault.setName(swap);
        derrick.setNumAbsences(student.getNumAbsences() + nonDefault.getNumAbsences());
        System.out.println(xavier.getLowestAbsences(student, derrick, nonDefault));


        ArrayList<Record> records = new ArrayList<>();
        records.add(student);
        records.add(derrick);
        records.add(nonDefault);
        int high = student.getNumAbsences();
        String most = student.getName();
        for (Record record : records) {
            if (record.getNumAbsences() > high) {
                most = record.getName();
                high = record.getNumAbsences();
            }
            System.out.println(most);

        }
        for (Record record : records) {
            if (record.getNumAbsences() % 2 == 0) {
                record.setNumAbsences(record.getNumAbsences() + 1);
            }
            System.out.println(record);
        }

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

    public static Map<Integer, Integer> eachAbsence(ArrayList<Integer> list) {
        Collections.sort(list);
        Map<Integer, Integer> numAbsences = new HashMap<>();
        for (int key : numAbsences.keySet()) {
            if (numAbsences.containsKey(key)) {
                numAbsences.put(key, 1);
            }
        }
        return numAbsences;
    }

    public static ArrayList<Integer> userSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                if (list.get(i) < list.get(j)) {
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

    public static ArrayList<String> sameSize(ArrayList<Integer> absences, ArrayList<String> names) {
        Random rand = new Random();
        ArrayList<String> sameListSize = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            String name = names.get(rand.nextInt(5));
            sameListSize.add(name);
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

    public static ArrayList<String> perfectStudents(ArrayList<Integer> absences, ArrayList<String> names) {
        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
                students.add(names.get(absences.get(i)));
            }
        }
        return students;
    }

    public static ArrayList<String> studentsFE(ArrayList<Integer> list, ArrayList<String> names) {
        ArrayList<String> students = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

        }
        return students;
    }

    public static int numOfClasses(ArrayList<Integer> list, ArrayList<String> names) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (names.get(i).equals(list.get(i))) {
                count++;
            }
        }
        return count;
    }

    /*public static ArrayList<Integer> FEcourses (ArrayList<Integer> list, ArrayList<String> courses) {
        ArrayList<Integer> courseIndexes = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals()){

            }
        }
        return courseIndexes;


    }
    */
    public static LocalDate localDate() {
        LocalDate today = LocalDate.now();
        return today;
    }

    public static int daysAlive(int day, int month, int year) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        int totalYears = (int) birthDate.toEpochDay();
        int numDays = (int) today.toEpochDay();
        int totalDays = numDays - totalYears;
        return totalDays;
    }

    public static ArrayList<LocalDate> listOfDates(ArrayList<String> list, int month, int day, int year) {
        Random rand = new Random();
        ArrayList<LocalDate> dates = new ArrayList<>();
        LocalDate today = LocalDate.now();
        dates.add(today);
        LocalDate birthDay = LocalDate.of(year, month, day);
        dates.add(birthDay);
        for (int i = 0; i < list.size(); i++) {
            today = today.minusDays(rand.nextInt(20));
            dates.add(today);
        }
        return dates;
    }
    /*public static LocalDate min(ArrayList<LocalDate> dates) {
        LocalDate minTime = dates.get(0);
        for (int i = 0; i < dates.size(); i++) {
            if (dates.get(i).isBefore(minTime)) {

            }
        }
    }
    */


}
