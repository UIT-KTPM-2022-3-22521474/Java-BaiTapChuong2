import java.util.Arrays;
import java.util.Scanner;

class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction() {
        this(0, 1);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("Denominator cannot be 0, set to default value 1.");
            this.denominator = 1;
        }
    }

    protected void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        this.numerator = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denominator = scanner.nextInt();
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("Denominator cannot be 0, set to default value 1.");
            this.denominator = 1;
        }
    }

    protected int GCD(int a, int b) {
        int result;
        if (b == 0) {
            result = a;
        } else {
            result = GCD(b, a % b);
        }
        return result;
    }

    protected void Reduce() {
        int gcd = GCD(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    protected Fraction Sum(Fraction other) {
        int numeratorNew = this.numerator * other.denominator + other.numerator * this.denominator;
        int denominatorNew = this.denominator * other.denominator;
        Fraction sum = new Fraction(numeratorNew, denominatorNew);
        sum.Reduce();
        return sum;
    }

    @Override
    public int compareTo(Fraction other) {
        double value1 = (double) this.numerator / this.denominator;
        double value2 = (double) other.numerator / other.denominator;
        return Double.compare(value1, value2);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

}

public class BT3_Fraction {
    public static void main(String[] args) {
        System.out.println("\nFraction - To Vinh Tien - 22521474.");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of fractions: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Fraction[] fractions = new Fraction[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter " + getOrdinal(i + 1) + " fraction:");
            fractions[i] = new Fraction();
            fractions[i].Input();
        }

        System.out.println("\nEntered fractions:");
        for (int i = 0; i < n; i++) {
            System.out.println(getOrdinal(i + 1) + " fraction: " + fractions[i] + ".");
        }

        Fraction sum = new Fraction();
        for (int i = 0; i < n; i++) {
            sum = sum.Sum(fractions[i]);
        }
        System.out.println("\nSum of fractions: " + sum + ".");

        Arrays.sort(fractions);
        System.out.print("\nSorted list of fractions:");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + fractions[i]);
        }
        System.out.print(".");
        System.out.println();
    }
    private static String getOrdinal(int number) {
        int remainder10 = number % 10;
        int remainder100 = number % 100;
        if (remainder10 == 1 && remainder100 != 11) {
            return number + "st";
        } else if (remainder10 == 2 && remainder100 != 12) {
            return number + "nd";
        } else if (remainder10 == 3 && remainder100 != 13) {
            return number + "rd";
        } else {
            return number + "th";
        }
    }
}