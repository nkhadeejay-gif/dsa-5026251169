package lw01.unguided;

public abstract class WashService implements Billable {
    protected String id;
    protected int days;
    protected int units;

    public WashService(String id, int days, int units) {
        if (days <= 0 || days > 30) {
            throw new IllegalArgumentException("Days must be positive and not exceed 30");
        }
        if (units <= 0 || units > 10) {
            throw new IllegalArgumentException("Units must be positive and not exceed 10");
        }

        this.id = id;
        this.days = days;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override 
    public abstract int calculateCharge();
    
    public int calculateCharge(int units) {
        if (units <= 0 || units > 10){
            throw new IllegalArgumentException("Units must be positive and not exceed 10");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
