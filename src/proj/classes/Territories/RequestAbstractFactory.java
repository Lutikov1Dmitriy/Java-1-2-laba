package proj.classes.Territories;

import proj.interfaces.Territory;

import java.io.IOException;

public class RequestAbstractFactory {
    private final String POPULATION_FIELD = "Population";
    private final String YEAR_OF_FOUNDATION_FIELD = "YearOfFoundation";
    private final String NAME_FIELD = "Name";
    private InputContainer container = new InputContainer();

    public Territory createCity() {
        return new City(container.inputFieldData(POPULATION_FIELD),
                container.inputFieldData(YEAR_OF_FOUNDATION_FIELD),
                container.inputFieldData(NAME_FIELD));
    }

    public Territory createFarm() {
        return new City(container.inputFieldData(POPULATION_FIELD),
                container.inputFieldData(YEAR_OF_FOUNDATION_FIELD),
                container.inputFieldData(NAME_FIELD));
    }

    public Territory createHamlet() {
        return new City(container.inputFieldData(POPULATION_FIELD),
                container.inputFieldData(YEAR_OF_FOUNDATION_FIELD),
                container.inputFieldData(NAME_FIELD));
    }

    public Territory createSettlement() {
        return new City(container.inputFieldData(POPULATION_FIELD),
                container.inputFieldData(YEAR_OF_FOUNDATION_FIELD),
                container.inputFieldData(NAME_FIELD));
    }

    public Territory createVillage() {
        return new City(container.inputFieldData(POPULATION_FIELD),
                container.inputFieldData(YEAR_OF_FOUNDATION_FIELD),
                container.inputFieldData(NAME_FIELD));
    }
}
