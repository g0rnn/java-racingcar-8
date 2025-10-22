package racingcar;

public class Car {

    private final String name;
    private int position;

    Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int condition) {
        if (condition >= 4) {
            this.position += 1;
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
