package CloneTest;

/**
 * Created by zoujialei on 18/1/9.
 */
public class ClassCloneable extends ClassNotCloneable implements Cloneable {

    public ClassCloneable clone(ClassCloneable from){
        ClassCloneable to = new ClassCloneable();
        to.setName(from.getName());
        return to;
    }
}
