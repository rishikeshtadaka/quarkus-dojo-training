package org.fiserv.dojo.cdi;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestApplicationScoped {

    public TestApplicationScoped(){
        Log.info("Creating TestApplicationScoped");
    }
    private Integer counter=0;
    public Integer getCounter(){
        this.counter++;
        return this.counter;
    }
}
