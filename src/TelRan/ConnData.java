package TelRan;

/**
 * Created by Legat on 6/20/2016.
 */
public class ConnData {
    String proto;
    String port;
    long startDate;
    long endDate;

    public String getSomeData() {
        return someData;
    }

    String someData;

    public String getProto() {
        return proto;
    }

    public void setSomeData(String someData) {
        this.someData = someData;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public String getPort() {
        return port;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public void setPort(String port) {

        this.port = port;
    }

    public ConnData(String proto, String port) {
        this.proto = proto;
        this.port = port;
        startDate = System.currentTimeMillis();

    }
}
