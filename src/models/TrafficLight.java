package models;

public class TrafficLight {
    private final int id;
    private SignalType currentSignal;
    private int greenDuration;
    private int redDuration;
    private int yellowDuration;

    public TrafficLight(int id, int greenDuration, int redDuration, int yellowDuration) {

        this.id = id;
        this.currentSignal = SignalType.RED;
        this.greenDuration = greenDuration;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
    }

    public synchronized void changeSignal(SignalType signalType) {
        currentSignal = signalType;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }
}
