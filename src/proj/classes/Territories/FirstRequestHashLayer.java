package proj.classes.Territories;

import proj.classes.Main;
import proj.interfaces.LayerRemove;
import proj.interfaces.Logger;
import proj.interfaces.Territory;

import java.util.ArrayList;
import java.util.HashMap;

public class FirstRequestHashLayer implements LayerRemove {
    private Logger logger;
    private SecondRequestHashLayer secondLayerHandler;
    private int requestCounter = 0;
    private HashMap<String, Territory> firstLayerHash = new HashMap<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> counts = new ArrayList<>();

    public FirstRequestHashLayer(Logger logger) {
        this.logger = logger;
        secondLayerHandler = new SecondRequestHashLayer(logger);
    }

    public synchronized void setTerritory(Territory territory) {
        if (!names.contains(territory.getAuthenticationCode())) {
            firstLayerHash.put(territory.getAuthenticationCode(), territory);
            names.add(territory.getAuthenticationCode());
            counts.add(0);
        }
    }

    public synchronized Territory getTerritory(String name) {
        Territory territory = firstLayerHash.get(name);
        if (territory == null) {
            territory = secondLayerHandler.getTerritory(name);
        } else if (names.contains(name)) {
            counts.set(names.indexOf(name), counts.get(names.indexOf(name)) + 1);
            requestCounter++;
            if (requestCounter == Main.requestCounter) {
                requestCounter = 0;
                new CommonLayerRemove(this);
            }
        }
        return territory;
    }

    private int indexOfMinCount() {
        int index = 0;
        int min = counts.get(0);
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) < min) min = counts.get(i);
            index = i;
        }
        return index;
    }
    @Override
    public synchronized  void deleteOldElements() {
        int removeIndex = indexOfMinCount();
        secondLayerHandler.setTerritory(firstLayerHash.get(names.get(removeIndex)));
        firstLayerHash.remove(names.get(removeIndex));
        names.remove(removeIndex);
        counts.remove(removeIndex);
        logger.mapMessaging(firstLayerHash, Logger.INFO, "first level");
    }
}
