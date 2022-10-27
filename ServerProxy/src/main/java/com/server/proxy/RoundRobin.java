package com.server.proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RoundRobin {
     List<String> ipList;
    public RoundRobin(){
        List<String> ipList = new ArrayList<>();
        ipList.add("http://ec2-34-239-118-182.compute-1.amazonaws.com:4567");
        ipList.add("http://ec2-18-212-219-208.compute-1.amazonaws.com:4567");

        this.ipList = Collections.unmodifiableList(ipList);
    }

    abstract String getIp();
}
