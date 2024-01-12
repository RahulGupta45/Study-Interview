import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DemoSingleton {

    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        SingletonClass inst1 = SingletonClass.getInstance();
        System.out.println(inst1.hashCode());

        SingletonClass inst2 = SingletonClass.getInstance();
        System.out.println(inst2.hashCode());

        SingletonClass inst3 = SingletonClass.getInstance();
        System.out.println(inst3.hashCode());

        /*  1.) Clone
            Object scClone = inst2.clone();
            System.out.println(scClone.hashCode());
        */

        /* 2.) Reflection API
            Constructor[] constr = SingletonClass.class.getDeclaredConstructors();
            for(Constructor constructor : constr){
                constructor.setAccessible(true);
                inst3 = (SingletonClass) constructor.newInstance();
            }
            System.out.println(inst3.hashCode());
        */

        /* 3.) Serializing & Deserializing
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
        out.writeObject(inst2);
        out.close();

        ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
        inst3 = (SingletonClass) in.readObject();
        in.close();

        System.out.println("instance hashcode - 2 : "+inst2.hashCode());
        System.out.println("instance hashcode - 3: "+inst3.hashCode());

        1072408673
        1072408673
        1072408673
        instance hashcode - 2 : 1072408673
        instance hashcode - 3: 1305193908
        */

    }
}
