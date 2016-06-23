package TelRan;

import java.util.*;

/**
 * Created by Legat on 6/20/2016.
 */
public class ConnectionsCollection {
    public LinkedHashMap<ConnectionKey, ExtConnData> getExtConnDataLinkedHashMap() {
        return extConnDataLinkedHashMap;
    }

    LinkedHashMap<ConnectionKey, ExtConnData> extConnDataLinkedHashMap;

    synchronized public void addExtConnData(ExtConnData extConnData) {
        extConnDataLinkedHashMap.put(extConnData.getConKey(), extConnData);


    }

    synchronized public ExtConnData getFirstExtConn() {
        if (extConnDataLinkedHashMap.isEmpty()) {
            return null;
        } else {
            Iterator<ExtConnData> it = extConnDataLinkedHashMap.values().iterator();
            return it.next();
        }


    }
    synchronized public void deleteExtConnByKey (ConnectionKey connectionKey){
        extConnDataLinkedHashMap.remove(connectionKey);

    }
    synchronized public void deleteOldest(){
        Iterator<ExtConnData> it = extConnDataLinkedHashMap.values().iterator();
        extConnDataLinkedHashMap.remove(it.next().getConKey());
    }

}
