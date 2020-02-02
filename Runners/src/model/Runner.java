package model;

public class Runner extends Human implements Comparable<Runner> {
    public double profit;

    public Runner() {
    }

    public Runner(String fullName, int age, double profit) {
        super(fullName, age);
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    @Override
    public int compareTo(Runner o) {
        int result=0;

           result = this.fullName.compareTo(o.getFullName());
         if(result==0){

            }

        return 0;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(". " + fullName);
            stringBuilder.append("  " + age);
            stringBuilder.append("  " + profit+"\n");
        return stringBuilder.toString();

    }
}

