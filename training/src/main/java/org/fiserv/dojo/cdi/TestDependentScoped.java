package org.fiserv.dojo.cdi;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.Dependent;

@Dependent
public class TestDependentScoped {
    public TestDependentScoped(){
        Log.info("Creating TestDependentScoped");
    }
    private Integer counter=0;
    public Integer getCounter(){
        this.counter++;
        return this.counter;
    }
}
