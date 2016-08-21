
package edpro1;

public class EDPro1 {

    public static void main(String[] args) {
        TDALista list = new VSArray(4);
        Person  a = new Person(0, "juan", "sistemas");
        Person  b = new Person(1, "car", "sistemas");
        
        System.out.println(list.insert(a, 0));
        System.out.println(list.insert(b, 0));
        System.out.println(list.insert(b, 0));
        System.out.println(list.insert(b, 0));
        System.out.println(list.insert(b, 0));

        System.out.println(list.getSize());
        System.out.println(list.indexOf(a));
        System.out.println(list.erase(1));
        System.out.println(list.getSize());
    }
    
}
