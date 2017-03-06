package com.InnerClasses;

/**
 * Created by shikhar on 3/5/17.
 */
public class OuterClass {

    private int priv;
    public int pub;

    private class Inner {
        private int pr;
        public int pu;

        public Inner(int a) {
            priv = a;
            pub = a;
        }

    }

    private static class InnerStatic {
        private int pr;
        public int pu;

        public InnerStatic(int b) {
//            priv = b;
//            pub = b;
        }
    }


    public static void main(String[] args) {
        OuterClass IC = new OuterClass();
        OuterClass.Inner nonStatic = IC.new Inner(5);

        OuterClass.InnerStatic Static = new OuterClass.InnerStatic(5);
    }
}
