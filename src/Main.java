import models.TrafficController;
import models.TrafficLight;

public class Main {
    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight(1, 10, 10, 10);
        TrafficController trafficController = TrafficController.getInstance(trafficLight);

        trafficController.startTrafficControlSystem();

        trafficController.handleEmergency();
    }
}