package app.core.innerclasses;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static java.lang.System.out;

public class MethodParameterSpy {
    private static final String fmt = "%24s: %s%n";

    MethodParameterSpy() {
    }

    public static void printClassConstructors(Class<?> c) {
        Constructor<?>[] allConstructors = c.getConstructors();
        out.format(fmt, "Number of constructors", allConstructors.length);
        for (Constructor<?> currentConstructor : allConstructors) {
            printConstructor(currentConstructor);
        }
        Constructor<?>[] allDeclConst = c.getDeclaredConstructors();
        out.format(fmt, "Number of declared constructors",
                allDeclConst.length);
        for (Constructor<?> currentDeclConst : allDeclConst) {
            printConstructor(currentDeclConst);
        }
    }

    public static void printClassMethods(Class<?> c) {
        Method[] allMethods = c.getDeclaredMethods();
        out.format(fmt, "Number of methods", allMethods.length);
        for (Method m : allMethods) {
            printMethod(m);
        }
    }

    public static void printConstructor(Constructor<?> c) {
        out.format("%s%n", c.toGenericString());
        Parameter[] params = c.getParameters();
        out.format(fmt, "Number of parameters", params.length);
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }

    public static void printMethod(Method m) {
        out.format("%s%n", m.toGenericString());
        out.format(fmt, "Return type", m.getReturnType());
        out.format(fmt, "Generic return type", m.getGenericReturnType());

        Parameter[] params = m.getParameters();
        for (int i = 0; i < params.length; i++) {
            printParameter(params[i]);
        }
    }

    public static void printParameter(Parameter p) {
        out.format(fmt, "Parameter class", p.getType());
        out.format(fmt, "Parameter name", p.getName());
        out.format(fmt, "Modifiers", p.getModifiers());
        out.format(fmt, "Is implicit?", p.isImplicit());
        out.format(fmt, "Is name present?", p.isNamePresent());
        out.format(fmt, "Is synthetic?", p.isSynthetic());
    }

    public static void main(String... args) {
        class TestInside {
            private void show() {
                out.println("Hello");
            }
        }

        TestInside ts = new TestInside();
        ts.show();
    }

    // for the morbidly curious
    <E extends RuntimeException> void genericThrow() throws E {
    }
}
