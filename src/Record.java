import java.time.LocalDate;

public class Record {
    public String name;
    public int numAbsences;
    public LocalDate date;

    public Record() {
        name = "Derrick";
        numAbsences = 2;
        date = LocalDate.now();
    }

    public Record(String str, int num, LocalDate newDate) {
        name = str;
        numAbsences = num;
        date = newDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getNumAbsences() {
        return numAbsences;
    }

    public void setNumAbsences(int a) {
        numAbsences = a;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate d) {
        date = d;
    }

    public void setNumAbsences() {
        numAbsences = name.length();
    }

    public int getLowestAbsences(Record student, Record derrick, Record nonDefault) {
        int lowest = student.getNumAbsences();
        if (student.getNumAbsences() > derrick.getNumAbsences() && student.getNumAbsences() >
                nonDefault.getNumAbsences()) {
            lowest = student.getNumAbsences();
        } else if (derrick.getNumAbsences() > student.getNumAbsences() && derrick.getNumAbsences() >
                nonDefault.getNumAbsences()) {
            lowest = derrick.getNumAbsences();
        } else {
            lowest = nonDefault.getNumAbsences();
        }
        return lowest;
    }

    public LocalDate getYoungestRecord(Record student, Record derrick, Record nonDefault) {
        LocalDate young = student.getDate();

        if (student.getDate().isBefore(derrick.getDate()) && student.getDate().isBefore(nonDefault.getDate())) {
            young = student.getDate();
        } else if (derrick.getDate().isBefore(student.getDate()) && derrick.getDate().isBefore(nonDefault.getDate())) {
            young = derrick.getDate();
        } else {
            young = nonDefault.getDate();
        }
        return young;

    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s", name, numAbsences, date);
    }
}
