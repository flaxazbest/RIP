public class PowerSpeed extends Power {
    private double speedUp;

    public PowerSpeed(String name, double speedUp) {
        super(name);
        this.speedUp = speedUp;
    }

    public double getSpeedUp() {
        return speedUp;
    }


}
