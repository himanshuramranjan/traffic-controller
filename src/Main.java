import service.TrafficController;
import models.TrafficLight;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(1, 2000, 2000, 2000);
        TrafficController trafficController = TrafficController.getInstance(trafficLight);

        trafficController.startTrafficControlSystem();

        // Simulate emergency after a few seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred : " + e);
        }

        trafficController.handleEmergency();
    }
}
