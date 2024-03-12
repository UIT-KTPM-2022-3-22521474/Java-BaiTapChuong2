import java.util.Scanner;

class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void increaseSecond() {
        this.second++;
        if (this.second >= 60) {
            this.second = 0;
            this.minute++;
            if (this.minute >= 60) {
                this.minute = 0;
                this.hour++;
                if (this.hour >= 24) {
                    this.hour = 0;
                }
            }
        }
    }

    public int compareTime(Time otherTime) {
        if (this.hour > otherTime.hour) {
            return 1;
        } else if (this.hour < otherTime.hour) {
            return -1;
        } else if (this.minute > otherTime.minute) {
            return 1;
        } else if (this.minute < otherTime.minute) {
            return -1;
        } else return Integer.compare(this.second, otherTime.second);
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

public class BT2_Time {
    public static void main(String[] args) {
        System.out.println("\nTime - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter hour, minute, and second for time 1:");
        int hour1 = getValidInput(scanner, "hour", 23);
        int minute1 = getValidInput(scanner, "minute", 59);
        int second1 = getValidInput(scanner, "second", 59);

        System.out.println("\nEnter hour, minute, and second for time 2:");
        int hour2 = getValidInput(scanner, "hour", 23);
        int minute2 = getValidInput(scanner, "minute", 59);
        int second2 = getValidInput(scanner, "second", 59);

        Time time1 = new Time(hour1, minute1, second1);
        Time time2 = new Time(hour2, minute2, second2);

        System.out.println("\nTime 1: " + time1 + ".");
        System.out.println("Time 2: " + time2 + ".");

        int result = time1.compareTime(time2);
        if (result == 1) {
            System.out.println("\nTime 1 is greater than time 2.");
        } else if (result == -1) {
            System.out.println("\nTime 2 is greater than time 1.");
        } else {
            System.out.println("\nBoth times are equal.");
        }

        time1.increaseSecond();
        System.out.println("\nTime 1 after increasing by one second: " + time1 + ".");
    }

    private static int getValidInput(Scanner scanner, String field, int max) {
        int input = -1;
        while (input < 0 || input > max) {
            System.out.print("Enter " + field + " (" + 0 + "-" + max + "): ");
            input = scanner.nextInt();
            if (input < 0 || input > max) {
                System.out.println("Invalid " + field + "! Please enter again.");
            }
        }
        return input;
    }
}
