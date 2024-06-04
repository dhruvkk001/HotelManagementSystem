package org.example;

public class Services {
    private boolean laundry;
    private boolean spa;
    private int laundryUses;
    private int spaUses;
    private static final double LAUNDRY_COST_PER_USE = 5.0;
    private static final double SPA_COST_PER_USE = 10.0;

    public Services(boolean laundry, boolean spa, int laundryUses, int spaUses) {
        this.laundry = laundry;
        this.spa = spa;
        this.laundryUses = laundryUses;
        this.spaUses = spaUses;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public boolean isSpa() {
        return spa;
    }

    public int getLaundryUses() {
        return laundryUses;
    }

    public int getSpaUses() {
        return spaUses;
    }

    public double getLaundryCost() {
        return laundry ? laundryUses * LAUNDRY_COST_PER_USE : 0;
    }

    public double getSpaCost() {
        return spa ? spaUses * SPA_COST_PER_USE : 0;
    }

    @Override
    public String toString() {
        return "Services{" +
                "laundry=" + laundry +
                ", spa=" + spa +
                ", laundryUses=" + laundryUses +
                ", spaUses=" + spaUses +
                ", laundryCost=" + getLaundryCost() +
                ", spaCost=" + getSpaCost() +
                '}';
    }
}

