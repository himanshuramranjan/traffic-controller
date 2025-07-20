package models.state;

import models.SignalType;
import models.TrafficLight;

import static java.lang.Thread.sleep;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight) throws InterruptedException {
        trafficLight.changeSignal(SignalType.GREEN);
        System.out.println("Current Signal : GREEN");
        sleep(trafficLight.getRedDuration());
    }

    @Override
    public SignalState nextState() {
        return new YellowState();
    }
}
