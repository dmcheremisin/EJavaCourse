package exercises.module2.submarine;

import exercises.module2.annotation.EngineAnnotation;

import java.lang.annotation.Annotation;

/**
 * @author dmch0916
 *         Date: 23.08.2017
 *         Time: 19:21
 */
public class Main {

    public static void main(String[] args) {
        //NuclearSubmarine.SubmarineEngine nse = new NuclearSubmarine.SubmarineEngine(300);

        NuclearSubmarine ns = new NuclearSubmarine();
        Class engineClass = ns.getClass();
        Annotation annotation = engineClass.getAnnotation(EngineAnnotation.class);
        EngineAnnotation ea = (EngineAnnotation) annotation;
        System.out.println(ea.manufacturer());
    }

}