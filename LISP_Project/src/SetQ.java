/**
 * 
 */

/**
 * @author Jose Gramajo
 *
 */
import java.util.HashMap;
import java.util.Map;

public class SetQ<K, V> {
	private final Map<K, V> values;

    public SetQ() {
        values = new HashMap<>();
    }

    public void setq(K var, V val) {
        values.put(var, val);
    }

    public V get(K var) {
        return values.get(var);
    } 

}
