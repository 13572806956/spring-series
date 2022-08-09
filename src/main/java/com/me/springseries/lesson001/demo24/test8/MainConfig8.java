package com.me.springseries.lesson001.demo24.test8;

import org.springframework.context.annotation.Import;

/**
 * @author ME
 * @create 2022-08-09 0:15
 */
@Import({
        DeferredImportSelector1.class,
        DeferredImportSelector2.class,
})
public class MainConfig8 {
}
