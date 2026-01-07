package pl.nosky.hydration.domain;

public enum DrinkType {

    WATER(1.0),
    COFFEE(0.8),
    TEA(0.9),
    ENERGY_DRINK(0.75),
    BEER(0.6),
    LIQUOR(-0.2);

    private final double hydrationFactor;

    public double getHydrationFactor() {
        return hydrationFactor;
    }

    DrinkType(double hydrationFactor) {
        this.hydrationFactor = hydrationFactor;
    }

}
