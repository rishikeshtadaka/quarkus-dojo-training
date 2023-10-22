package org.fiserv.dojo.cdi;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Singleton;

@RequestScoped
public class TestRequestScoped {
    public TestRequestScoped(){
        Log.info("Creating TestRequestScoped");
    }
    private Integer counter=0;
    public Integer getCounter(){
        this.counter++;
        return this.counter;
    }
}
