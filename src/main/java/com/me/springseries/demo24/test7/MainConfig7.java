package com.me.springseries.demo24.test7;

import org.springframework.context.annotation.Import;

/**
 * @author ME
 * @create 2022-08-09 0:10
 */
@Import({
        DeferredImportSelector1.class,
        Configuration3.class,
        ImportSelector1.class
})
public class MainConfig7 {
}
