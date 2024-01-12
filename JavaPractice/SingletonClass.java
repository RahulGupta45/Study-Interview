import java.io.Serializable;

public class SingletonClass extends MyClone implements Serializable {

    private static SingletonClass sc;

    private SingletonClass() {
        if(sc != null){
            throw new RuntimeException("Not able to create instance ");
        }
    }

    public static SingletonClass getInstance() {
        if (sc == null) {
            sc = new SingletonClass();
        }
        return sc;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private Object readResolve(){
        return sc;
    }
}