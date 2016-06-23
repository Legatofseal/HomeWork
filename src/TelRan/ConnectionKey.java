package TelRan;

/**
 * Created by Legat on 6/21/2016.
 */
public class ConnectionKey {
    String destination;
    String source;


    public ConnectionKey(String destination, String source) {
        this.destination = destination;
        this.source = source;

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
        return getSource().equals(that.getSource());

    }

    @Override
    public int hashCode() {
        int result = getDestination().hashCode();
        result = 31 * result + getSource().hashCode();
        return result;
    }

    public String getSource() {
        return source;

    }


}
