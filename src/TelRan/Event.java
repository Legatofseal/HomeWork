package TelRan;

/**
 * Created by Legat on 6/22/2016.
 */
public class Event implements Runnable{
    boolean eventType; //true for Start, false for End
    ExtConnData extConnData;


    public Event(boolean eventType, ExtConnData extConnData) {
        this.eventType = eventType;
        this.extConnData = extConnData;

    }

    public boolean getEventType() {
        return eventType;
    }

    public ExtConnData getExtConnData() {
        return extConnData;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random()*3600000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        extConnData.getConnData().setSomeData("Current time="+System.currentTimeMillis());

    }
}
