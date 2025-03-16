package EmployeeObjects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Added the retention policy as runtime
// Made the PayRate annotation a field annotation
// Added the type parameter
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface PayRate {
    String type();
}
