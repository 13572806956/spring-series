package com.me.demo26.test8;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tag1")
public class Service2 implements IService {
}
