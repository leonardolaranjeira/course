package entities;

public class Student {
    public String name;
    public double note;
    public double sum;

    // Constant
    public static final double PASSING_GRADE = 60;

    public void addNote(double value) {
        this.sum += value;
    }
}

    /*
    public double average;

    public void getAverage() {
        average = sum / 3;
        System.out.println("FINAL GRADE = " + sum);
        if (average >= 100 - (0.60 / 100)) {
            System.out.println("PASS");
            System.out.println("WITH: " + String.format("%.2f", average) + "POINTS");
        } else {
            System.out.println("FAILED");
            System.out.println("MISSING " + String.format("%.2f", (average - 60)) + "POINTS");
        }
    }
    */
