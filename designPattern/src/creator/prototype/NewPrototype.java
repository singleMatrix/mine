package creator.prototype;

import creator.builder.ConcreteBuilder;

import java.io.*;

/**
 * Created by single on 17/4/5.
 */
public class NewPrototype implements Serializable {
    private ConcreteBuilder concreteBuilder;

    public ConcreteBuilder getConcreteBuilder() {
        return concreteBuilder;
    }

    public void setConcreteBuilder(ConcreteBuilder concreteBuilder) {
        this.concreteBuilder = concreteBuilder;
    }

    public Object deepClone(){
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bo);
            oos.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bi);
            NewPrototype np = (NewPrototype) ois.readObject();
            return np;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        NewPrototype np = new NewPrototype();
        np.setConcreteBuilder(new ConcreteBuilder());

        NewPrototype np2 = (NewPrototype) np.deepClone();
        System.out.println(np.getConcreteBuilder() == np2.getConcreteBuilder());
    }
}
