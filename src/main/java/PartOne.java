import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anthonyjones on 5/4/17.
 */
public class PartOne {

    public boolean classImplementsInterface(Object classObject, String interfaceName) {

        String testForInterface = classObject.getClass().getInterfaces()[0].getSimpleName();
        if (testForInterface.equals(interfaceName)) {
            return true;
        }
        return false;

    }

    public String listAllMember(Object classObject) {

        System.out.println("Fields");
        for (int i = 0; i < classObject.getClass().getFields().length; i++) {
            System.out.print(classObject.getClass().getFields()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getFields()[i]);
        }

        System.out.println("Constructors");
        for (int i = 0; i < classObject.getClass().getConstructors().length; i++) {
            System.out.print(classObject.getClass().getConstructors()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getConstructors()[i]);
        }

        System.out.println("Methods");
        for (int i = 0; i < classObject.getClass().getMethods().length; i++) {
            System.out.print(classObject.getClass().getMethods()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getMethods()[i]);

            if (classObject.getClass().getMethods()[i].toString().equals("public final native void java.lang.Object.notifyAll()")) {
                return classObject.getClass().getMethods()[classObject.getClass().getMethods().length - 1].toString();
            }
        }
        return "";
    }

    public String getClassHierarchy(Object classObject) {

        Object holdObject = classObject;
        Class thisClass = classObject.getClass();

        List<Class> listOfClasses = new ArrayList<>();

        listOfClasses.add(thisClass);
        while (thisClass.getSuperclass() != null) {
            thisClass = thisClass.getSuperclass();
            listOfClasses.add(thisClass);
        }

        for (int i = listOfClasses.size(); i > 0; i--) {

            System.out.println(listOfClasses.get(i - 1).getSimpleName());

            while(i>1){
                System.out.print(" ");
            }


        }

        // System.out.println(listOfMethods.get(2));

        // System.out.println(listOfMethods.stream().distinct().collect(Collectors.toList()));


        //holdObject = classObject.getClass().getMethods()[i].getDeclaringClass().getSimpleName();

//
//          String[] a= listOfMethods.stream().distinct().collect(Collectors.toList()).toString().split(" ");
//            System.out.println(a[0]);
//            System.out.println(listOfMethods.stream().distinct().collect(Collectors.toList()));


        return "";
    }

}
