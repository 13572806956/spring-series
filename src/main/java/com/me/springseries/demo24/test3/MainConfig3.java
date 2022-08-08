package com.me.springseries.demo24.test3;

import com.me.springseries.demo24.test3.module1.CompontentScanModule1;
import com.me.springseries.demo24.test3.module2.CompontentScanModule2;
import org.springframework.context.annotation.Import;

/**
 * @author ME
 * @create 2022-08-08 21:30
 */
@Import({CompontentScanModule1.class, CompontentScanModule2.class})
public class MainConfig3 {
}
