package org.bhupinder.zversal.messenger.patch;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;
import javax.ws.rs.HttpMethod;
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
public @interface PATCH {
}