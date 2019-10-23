package Assignment7;

public class PhoneCall {
    String number;
    int duration;
    String date;
    String calleeName;
    double cost;

    public PhoneCall(String number, int duration, String date, String calleeName, double cost) {
        this.number = number;
        this.duration = duration;
        this.date = date;
        this.calleeName = calleeName;
        this.cost = cost;
    }

    public String getNumber() {
        return number;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }

    public String getCalleeName() {
        return calleeName;
    }

    public double getCost() {
        return cost;
    }
}
