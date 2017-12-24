package proj.classes.Territories;

import proj.classes.Main;
import proj.interfaces.LayerRemove;
import proj.interfaces.Logger;
import proj.interfaces.Territory;

import java.util.HashMap;
import java.util.LinkedList;

public class SecondRequestHashLayer implements LayerRemove{
    private Logger logger;
    private int requestCounter = 0;
    private HashMap<String, Territory> secondLayerHash = new HashMap<>();
    private LinkedList<String> names = new LinkedList<>();
    private LinkedList<Integer> counts = new LinkedList<>();

    public SecondRequestHashLayer(Logger logger) {
        this.logger = logger;
    }

    public synchronized void setTerritory(Territory territory) {
        secondLayerHash.put(territory.getAuthenticationCode(), territory);
        if (!names.contains(territory.getAuthenticationCode())) {
            names.add(territory.getAuthenticationCode());
            counts.add(0);
        }
    }

    public synchronized Territory getTerritory(String name) {
        Territory territory = secondLayerHash.get(name);
        if (territory != null && names.contains(name)) {
            counts.set(names.indexOf(name), counts.get(names.indexOf(name)) + 1);
            requestCounter++;
            if (requestCounter == Main.requestCounter) {
                requestCounter = 0;
                new CommonLayerRemove(this);
            }
        } else {
            territory = null;
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
        secondLayerHash.remove(names.get(removeIndex));
        names.remove(removeIndex);
        counts.remove(removeIndex);
        logger.mapMessaging(secondLayerHash, Logger.INFO, "second layer");
    }
}
