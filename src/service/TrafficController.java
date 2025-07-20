package service;

import models.SignalType;
import models.TrafficLight;
import models.state.RedState;
import models.state.SignalState;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TrafficController {

    private final TrafficLight trafficLight;
    private final ScheduledExecutorService scheduler;
    private SignalState currentState;

    private TrafficController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        this.currentState = new RedState();
    }

    private static class TrafficControllerHandler {
        private static TrafficController INSTANCE;

        private static void initialize(TrafficLight trafficLight) {
            if (INSTANCE == null) {
                INSTANCE = new TrafficController(trafficLight);
            }
        }
    }

    public static TrafficController getInstance(TrafficLight trafficLight) {
        TrafficControllerHandler.initialize(trafficLight);
        return TrafficControllerHandler.INSTANCE;
    }

    public void startTrafficControlSystem() {
        scheduler.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    currentState.handle(trafficLight);
                } catch (InterruptedException e) {
                    System.out.println("Exception happened : " + e);
                }
                currentState = currentState.nextState();
            }
        });
    }

    public void handleEmergency() {
        System.out.println("Emergency Mode Activated: Switching to GREEN");
        trafficLight.changeSignal(SignalType.GREEN);
        try {
            Thread.sleep(trafficLight.getGreenDuration());
        } catch (InterruptedException e) {
            System.out.println("Exception happened : " + e);
        }
    }
}