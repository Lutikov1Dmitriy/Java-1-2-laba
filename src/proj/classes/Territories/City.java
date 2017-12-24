package proj.classes.Territories;

import proj.interfaces.Territory;

public class City implements Territory {
    private String name;
    private String population;
    private String yearOfFoundation;

    public City(String population, String yearOfFoundation, String name) {
        this.population = population;
        this.yearOfFoundation = yearOfFoundation;
        this.name = name;
    }

    @Override
    public String getInformation() {
        StringBuilder builder = new StringBuilder();
        builder.append("City: ");
        builder.append("name: ");
        builder.append(name);
        builder.append(" population: ");
        builder.append(population);
        builder.append(" yearOfFoundation: ");
        builder.append(yearOfFoundation);
        return builder.toString();
    }

    @Override
    public String getAuthenticationCode() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(String yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) return false;
        if (obj == this) return true;
        return ((City) obj).getYearOfFoundation().equals(this.yearOfFoundation)
                && ((City) obj).getPopulation().equals(this.population)
                && ((City) obj).getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + name.hashCode();
        hash = hash * 31 + yearOfFoundation.hashCode();
        hash = hash * 31 + population.hashCode();
        return hash;
    }
}
