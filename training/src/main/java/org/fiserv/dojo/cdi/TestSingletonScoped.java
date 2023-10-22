package org.fiserv.dojo.cdi;

import io.quarkus.logging.Log;
import jakarta.inject.Singleton;

@Singleton
public class TestSingletonScoped {
    public TestSingletonScoped(){
        Log.info("Creating TestSingletonScoped");
    }
    private Integer counter=0;
    public Integer getCounter(){
        this.counter++;
        return this.counter;
    }
}
