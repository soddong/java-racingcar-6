package racingcar.domain.car;

import racingcar.domain.game.GameCondition;
import racingcar.dto.Car;

public class CarMovement {
    Car raceCar;
    private static final CarInfo carStore = CarInfo.getInstance();

    public CarMovement(Car car) {
        this.raceCar = car;
        decideMovement();
    }

    private void decideMovement() {
        if (GameCondition.hasDriveCondition()) {
            raceCar = drive(raceCar);
            carStore.updateCarInfo(raceCar);
        }
    }

    private Car drive(Car currentCar) {
        return new Car(currentCar.name(), currentCar.position() + 1);
    }

    private Car Stop(Car currentCar) {
        return new Car(currentCar.name(), currentCar.position());
    }

    public Car car() {
        return raceCar;
    }
}
