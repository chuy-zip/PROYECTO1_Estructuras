import java.util.HashMap;
import java.util.Map;

/**
 * SetQ class that allows to store key-value pairs and access them by their key.
 * @param <K> Type of the key
 * @param <V> Type of the value
 */
public class SetQ<K, V> {
	private final Map<K, V> values;

	/**
     * Creates an instance of SetQ with an empty map.
     */
    public SetQ() {
        values = new HashMap<>();
    }

    /**
     * Assigns the specified value to the specified key.
     * @param var Key to be assigned the value.
     * @param val Value to assign to the key.
     */
    public void setq(K var, V val) {
        values.put(var, val);
    }

    /**
     * Returns the value associated with the specified key.
     * @param var Key to get the value from.
     * @return Value associated with the key, or null if the key is not found in the map.
     */
    public V get(K var) {
        return values.get(var);
    } 

}
