package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int units) {
        super(id, days, units);
    }

    @Override 
    public int calculateCharge() {
        int charge;
        if (getDays() <= 3) {
            charge = getDays() * 35000;
        } else {
            charge = (3 * 35000) + ((getDays() - 3) * 25000);
        }

        return charge + 15000; 
    }

    @Override 
    public String label() {
        return "Car";
    }
}
