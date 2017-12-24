package proj.classes.Territories;

import proj.interfaces.LayerRemove;

public class CommonLayerRemove implements Runnable{
    private Thread t;
    private LayerRemove layerRemove;
    public CommonLayerRemove(LayerRemove layerRemove){
        t = new Thread(this);
        this.layerRemove = layerRemove;
        t.start();
    }
    @Override
    public void run() {
        layerRemove.deleteOldElements();
    }
}
