import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 1L;

    // Volatile ensures visibility and prevents instruction reordering
    private static volatile Singleton instance;

    // Flag to prevent reflection
    private static boolean instanceCreated = false;

    // Private constructor
    private Singleton() {
        if (instanceCreated) {
            throw new RuntimeException("Reflection not allowed: Use getInstance()");
        }
        instanceCreated = true;
    }

    // Thread-safe lazy initialization with double-checked locking
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Prevent creating new instance during deserialization
    @Serial
    protected Object readResolve() {
        return getInstance();
    }

    // Prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed");
    }
}
