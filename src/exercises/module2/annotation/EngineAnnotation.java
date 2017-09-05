package exercises.module2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dmch0916
 *         Date: 24.08.2017
 *         Time: 13:08
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EngineAnnotation {
    String model() default "S";
    String manufacturer() default "Siemens";
    int series() default 1;
}