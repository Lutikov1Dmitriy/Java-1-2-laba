package proj.classes.Territories;

import proj.interfaces.Logger;
import proj.interfaces.Territory;

import java.util.Map;

public class MapLogger implements Logger {
    @Override
    public void mapMessaging(Map<String, Territory> map, String level, String comment) {
        System.out.println("----------");
        System.out.println(level);
        System.out.println(comment);
        for (String element : map.keySet()) {
            System.out.println(map.get(element).getInformation());
        }
        System.out.println("----------");
    }
}
