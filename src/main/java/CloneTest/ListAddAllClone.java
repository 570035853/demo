package CloneTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2019/3/3 .
 */
public class ListAddAllClone {

    public static void main(String[] args) {
        // deep cloning Collection in Java
        List<Employee> list1= new ArrayList();
        list1.add(new Employee("Joe", "Manager"));
        list1.add(new Employee("Tim", "Developer"));
        list1.add(new Employee("Frank", "Developer"));

        // creating copy of Collection using copy constructor
        List<Employee> list2 = new ArrayList();
        list2.addAll(list1);

        list1.get(0).setName("chen");

        System.out.println(list2.get(0).getName());


        List<Object> aList =  new ArrayList<Object>();
        List<Object> bList = new ArrayList<Object>();
        aList.add("1");
        aList.add("2");

        bList.addAll(aList);
        aList.set(1, 22);
        aList.clear();
        aList = null;

        System.out.println(bList.get(1));

        List<Object> cList =  new ArrayList<Object>();
        List<Object> dList = new ArrayList<Object>();
        cList.add(new Integer(1));
        cList.add(new Integer(2));

        dList.addAll(cList);
        cList.set(1, 22);
        cList.clear();
        cList = null;

        System.out.println(dList.get(1));
    }


    static class Employee{

        private String name;
        private String position;

        public Employee(String name, String position){
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
