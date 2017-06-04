package Ex2;

import java.lang.annotation.*;

/**
 * Created by Anastasia on 15.01.2017.
 */
//@Inherited
//@Target(value= ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String path();
}
