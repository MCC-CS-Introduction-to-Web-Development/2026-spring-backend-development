package class5;

public class Motorcycle extends Vehicle implements SteeringBehavior {
    private boolean radio;
    private boolean isHarley;

    public boolean isRadio() {
        return radio;
    }

    public Motorcycle setRadio(boolean radio) {
        this.radio = radio;
        return this;
    }

    public boolean isHarley() {
        return isHarley;
    }

    public Motorcycle setHarley(boolean harley) {
        isHarley = harley;
        return this;
    }

    @Override
    public String honkHorn(){
        return "vroom vroom!";
    }


    @Override
    public String turnLeft(int degrees) {
        return "Turn on left turn signal; Turn handlebars left; Lean left; and drive until at " + degrees + " degrees.";
    }

    @Override
    public String turnRight(int degrees) {
        return "Turn on right turn signal; Turn handlebars right; Lean right; and drive until at " + degrees + " degrees.";
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                "radio=" + radio +
                ", isHarley=" + isHarley +
                '}';
    }
}
