package com.lhl.test.thrifttest;

import org.apache.thrift.TException;

/**
 * Created by liuhonglin on 2016/9/18.
 */
public class HelloImpl implements Hello.Iface {

    @Override
    public String helloString(String word) throws TException {
        return "Hi. " + word + " welcome to thrift world.";
    }
}
