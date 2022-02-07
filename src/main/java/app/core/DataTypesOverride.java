package app.core;

public class DataTypesOverride {

    public static void main(String[] args) {
        DataTypesOverride dt = new DataTypesOverride();
        String s = null;
        Integer p = null;
        dt.nullCheck(s);
        dt.nullCheck(p);
        Float f = null;
        dt.nullCheck(f);
        int a = 56_3;
        int v = -563;
        System.out.println(a);
        System.out.println(v);
    }

    public void nullCheck(Object o) {
        System.out.println("Object o = " + o);
    }

    public void nullCheck(Integer o) {
        System.out.println("Integer o = " + o);
    }

    public void nullCheck(int o) {
        System.out.println("int o = " + o);
    }

    public void nullCheck(String o) {
        System.out.println("String o = " + o);
    }
}
