public class Fraction {
    private int numerator, denominator;

    public Fraction(int num, int denom) {
        numerator = num;
        denominator = denom;
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }
    }

    public Fraction(int num) {
        numerator = num;
        denominator = 1;
    }

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }


    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Fraction add(Fraction other) {
        int num = numerator * other.denominator + other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction subtract(Fraction other) {
        int num = numerator * other.denominator - other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction multiply(Fraction other) {
        int num = numerator * other.numerator;
        int denom = denominator * other.denominator;
        return new Fraction(num, denom);
    }

    public Fraction divide(Fraction other) {
        int num = numerator * other.denominator;
        int denom = denominator * other.numerator;
        return new Fraction(num, denom);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            this.toLowestTerms();
            ((Fraction) other).toLowestTerms();
            return numerator == ((Fraction) other).numerator && denominator == ((Fraction) other).denominator;
        } else {
            return false;
        }
    }

    public void toLowestTerms() {
        int GCD = gcd(Math.abs(numerator), Math.abs(denominator)); //prevent a negative number cause a exception
        numerator /= GCD;
        denominator /= GCD;
    }

    public int gcd(int num, int denom) {
        if (num == 0 || denom == 0) {
            return Math.max(num, denom);
        } else {
            if (num == denom) {
                return num;
            } else if (num > denom) {
                return gcd(num % denom, denom);
            } else {
                return gcd(num, denom % num);
            }

        }
    }
}
