package TelRan;

import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Legat on 6/22/2016.
 */
public class Controller {
    ConnectionsCollection container;
    LinkedHashMap<ConnectionKey, Thread> threadLinkedHashMap;

    public Controller(ConnectionsCollection container) {
        this.container = container;
    }

    public ConnectionsCollection getContainer() {
        return container;
    }

    class DeleteOldConn extends TimerTask {
        ConnectionKey connectionKey;

        public DeleteOldConn(ConnectionKey connectionKey) {
            this.connectionKey = connectionKey;
        }

        @Override
        public void run() {
            container.deleteExtConnByKey(connectionKey);
            threadLinkedHashMap.get(connectionKey).interrupt();

        }
    }

    public void stopConn(ConnectionKey connectionKey) {
        Timer timer = new Timer();
        timer.schedule(new DeleteOldConn(connectionKey), 3600000);
    }

    public void handleEvent(Event event) {
        if (event.getEventType().equals(Event.type.Start)) {
            if (container.getExtConnDataLinkedHashMap().get(event.getExtConnData().getConKey()) != null) {
                container.deleteExtConnByKey(event.getExtConnData().getConKey());
                threadLinkedHashMap.get(event.getExtConnData().getConKey()).interrupt();

                container.addExtConnData(event.getExtConnData());
                Thread eventThr = new Thread(event);
                threadLinkedHashMap.put(event.getExtConnData().getConKey(), eventThr);
                stopConn(event.getExtConnData().getConKey());

            } else {
                container.addExtConnData(event.getExtConnData());
                Thread eventThr = new Thread(event);
                threadLinkedHashMap.put(event.getExtConnData().getConKey(), eventThr);
                stopConn(event.getExtConnData().getConKey());
            }
        } else {
            if (container.getExtConnDataLinkedHashMap().get(event.getExtConnData().getConKey()) != null) {
                container.deleteExtConnByKey(event.getExtConnData().getConKey());
                threadLinkedHashMap.get(event.getExtConnData().getConKey()).interrupt();
            }


        }
    }

    public void putEvent(Event event) {
        if (event.getEventType().equals( Event.type.Start)) {
            if (threadLinkedHashMap.size() > 30000000) {
                container.deleteOldest();
                handleEvent(event);
            }
        }
        else {
            handleEvent(event);
        }
    }
}
