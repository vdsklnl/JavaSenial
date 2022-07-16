package ReflectionTest.Prepare;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author vdsklnl
 * @create 2022-04-26 11:08
 * @Description
 */

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)

public @interface MyAnnotation {

    String value() default "hello";

}
