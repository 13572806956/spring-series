package com.me.demo24.test7;

import org.springframework.context.annotation.Import;

@Import({
        DeferredImportSelector1.class,
        Configuration3.class,
        ImportSelector1.class
})
public class MainConfig7 {
}
