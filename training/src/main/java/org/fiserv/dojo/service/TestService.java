package org.fiserv.dojo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.fiserv.dojo.cdi.TestDependentScoped;
import org.fiserv.dojo.cdi.TestRequestScoped;

@Dependent
public class TestService {
    @Inject
    TestDependentScoped testDependentScoped;

    @Inject
    TestRequestScoped testRequestScoped;

    public Integer getDependentCounter(){
        return this.testDependentScoped.getCounter();
    }

    public Integer getRequestCounter(){
        return this.testRequestScoped.getCounter();
    }
}
