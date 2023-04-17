package com.me.demo26.test8;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tag2")//@1
public class Service3 implements IService {
}
