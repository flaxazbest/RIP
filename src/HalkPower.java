public final class HalkPower extends Power {

    private double duration;

    public HalkPower(String name, double duration) {
        super(name);
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }
}
