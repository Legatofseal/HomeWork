package TelRan;

/**
 * Created by Legat on 6/21/2016.
 */
public class ConnectionKey {
    String destination;
    String source;
    String port;
    String proto;

    public ConnectionKey(String destination, String source, String port, String proto) {
        this.destination = destination;
        this.source = source;
        this.port = port;
        this.proto = proto;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectionKey that = (ConnectionKey) o;

        if (!getDestination().equals(that.getDestination())) return false;
        if (!getSource().equals(that.getSource())) return false;
        if (!getPort().equals(that.getPort())) return false;
        return getProto().equals(that.getProto());

    }

    @Override
    public int hashCode() {
        int result = getDestination().hashCode();
        result = 31 * result + getSource().hashCode();
        result = 31 * result + getPort().hashCode();
        result = 31 * result + getProto().hashCode();
        return result;
    }

    public String getSource() {
        return source;
    }

    public String getPort() {
        return port;
    }

    public String getProto() {
        return proto;
    }
}
