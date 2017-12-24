package proj.classes.Territories;

import proj.interfaces.Territory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleGUI {
    private RequestHashManager manager;
    private BufferedReader reader;
    private final String CITY_TYPE1 = "City";
    private final String CITY_TYPE2 = "Farm";
    private final String CITY_TYPE3 = "Hamlet";
    private final String CITY_TYPE4 = "Settlement";
    private final String CITY_TYPE5 = "Village";

    public ConsoleGUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        manager = new RequestHashManager();
    }

    public void Start() throws IOException {
        while (true) {
            String command;
            System.out.println("Input command: ");
            command = reader.readLine();
            if (command.equals("set")) {
                setTerrainType();
            } else if (command.equals("get")) {
                String name = getTerritoryName();
                Territory territory = manager.getTerritory(name);
                getTerritoryInformation(territory);
            } else {
                System.out.println("Wrong command");
            }

        }
    }

    private void getTerritoryInformation(Territory territory) {
        if (territory == null) System.out.println("No such territory");
        else {
            System.out.println(territory.getInformation());
        }
    }

    private void setTerrainType() throws IOException {
        System.out.println("Input type of territory: ");
        String command = reader.readLine();
        switch (command) {
            case CITY_TYPE1:
                manager.setCity();
                break;
            case CITY_TYPE2:
                manager.setFarm();
                break;
            case CITY_TYPE3:
                manager.setHamlet();
                break;
            case CITY_TYPE4:
                manager.setSettlement();
                break;
            case CITY_TYPE5:
                manager.setVillage();
                break;
            default:
                System.out.println("Wrong type");
                break;
        }
    }

    private String getTerritoryName() {
        String territoryType = null;
        System.out.println("Input name of territory: ");
        try {
            territoryType = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return territoryType;
    }
}
