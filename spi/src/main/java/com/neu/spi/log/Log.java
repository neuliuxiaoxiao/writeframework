package com.neu.spi.log;

import com.neu.spi.annotation.Spi;

@Spi("neuLog")
public interface Log {

    void say();

}