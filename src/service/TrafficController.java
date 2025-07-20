package models;

public class TrafficController {

    public static volatile TrafficController trafficController;

    private TrafficController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public static class TrafficControllerHolder {
        private static final TrafficController INSTANCE = new TrafficController()
    }

    public static TrafficController getInstance(TrafficLight trafficLight) {
        return trafficController;
    }

    private final TrafficLight trafficLight;


    public void startTrafficControlSystem() {
        new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(trafficLight.getRedDuration());
                    trafficLight.changeSignal(SignalType.GREEN);
                    Thread.sleep(trafficLight.getGreenDuration());
                    trafficLight.changeSignal(SignalType.YELLOW);
                    Thread.sleep(trafficLight.getYellowDuration());
                    trafficLight.changeSignal(SignalType.RED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void handleEmergency() {
        trafficLight.changeSignal(SignalType.GREEN);
        try {
            Thread.sleep(trafficLight.getGreenDuration());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
