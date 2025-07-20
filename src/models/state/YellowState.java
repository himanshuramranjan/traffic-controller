package models.state;

import models.SignalType;
import models.TrafficLight;

import static java.lang.Thread.sleep;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight trafficLight) throws InterruptedException {
        trafficLight.changeSignal(SignalType.YELLOW);
        System.out.println("Current Signal : YELLOW");
        sleep(trafficLight.getRedDuration());
    }

    @Override
    public SignalState nextState() {
        return new GreenState();
    }
}
