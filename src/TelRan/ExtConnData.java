package TelRan;

/**
 * Created by Legat on 6/20/2016.
 */
public class ExtConnData {
    String sourceHostName;
    String destinationHostName;
    ConnData connData;

    public ExtConnData(String sourceHostName, String destinationHostName, ConnData connData) {
        this.sourceHostName = sourceHostName;
        this.destinationHostName = destinationHostName;
        this.connData = connData;
    }

    public String getSourceHostName() {
        return sourceHostName;
    }

    public ConnectionKey getConKey (){
        return new ConnectionKey(destinationHostName, sourceHostName, connData.getPort(), connData.getProto());
    }

    public String getDestinationHostName() {
        return destinationHostName;

    }

    public ConnData getConnData() {
        return connData;
    }
}
