package proj.classes.Territories;

import proj.interfaces.Logger;
import proj.interfaces.Territory;

public class RequestHashManager {
    private Logger logger = new MapLogger();
    private RequestAbstractFactory abstractFactory = new RequestAbstractFactory();
    private FirstRequestHashLayer firstLayerHandler = new FirstRequestHashLayer(logger);

    public RequestHashManager() {

    }

    public void setCity() {
        firstLayerHandler.setTerritory(abstractFactory.createCity());
    }

    public void setFarm() {
        firstLayerHandler.setTerritory(abstractFactory.createFarm());
    }

    public void setHamlet() {
        firstLayerHandler.setTerritory(abstractFactory.createHamlet());
    }

    public void setSettlement() {
        firstLayerHandler.setTerritory(abstractFactory.createSettlement());
    }

    public void setVillage() {
        firstLayerHandler.setTerritory(abstractFactory.createVillage());
    }

    public Territory getTerritory(String name) {
        return firstLayerHandler.getTerritory(name);
    }
}
