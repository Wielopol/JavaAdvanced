package pl.sda.java.adv.school.model;

public enum GradeWeight {
    AKT (1.0),
    PYT (1.5),
    EGZ (2.0);

    private double weight;

    GradeWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
