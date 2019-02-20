package javaReference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jialei.zou on 2018/11/18 .
 */
public class WeakReferenceTest {


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        WeakReference<StringBuilder> weakBuilder = new WeakReference<StringBuilder>(stringBuilder);

        stringBuilder = weakBuilder.get();
        Object[] objects = new Object[100];
        WeakReference<Bean> [] refs = new WeakReference[10000];

    }

}
