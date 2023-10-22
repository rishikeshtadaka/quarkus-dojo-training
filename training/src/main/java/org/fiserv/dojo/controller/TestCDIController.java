package org.fiserv.dojo.controller;


import io.quarkus.logging.Log;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.fiserv.dojo.cdi.TestApplicationScoped;
import org.fiserv.dojo.cdi.TestDependentScoped;
import org.fiserv.dojo.cdi.TestRequestScoped;
import org.fiserv.dojo.cdi.TestSingletonScoped;
import org.fiserv.dojo.service.TestService;

@Path("/test-cdi")
@Dependent
public class TestCDIController {
    public TestCDIController(){
        Log.info("Creating TestCDIController");
    }
    @Inject
    TestApplicationScoped testApplicationScoped;

    @Inject
    TestSingletonScoped testSingletonScoped;

    @Inject
    TestRequestScoped testRequestScoped;

    @Inject
    TestDependentScoped testDependentScoped;

    @Inject
    TestService testService;

    @GET
    public Response counter(){
        Log.info("Before invoking counter method");
        Integer applicationScopedCounter=this.testApplicationScoped.getCounter();
        Integer singletonScopedCounter=this.testSingletonScoped.getCounter();
        Integer requestScopedCounter=this.testRequestScoped.getCounter();
        Integer dependentScopedCounter=this.testDependentScoped.getCounter();
        Integer dependentScopedServiceCounter=this.testService.getDependentCounter();
        Integer requestScopedServiceCounter=this.testService.getRequestCounter();
        String counterText=String.format("applicationScopedCounter:%d, singletoneScopedCounter=%d, requestScopedCounter=%d, " +
                "dependentCounter=%d, dependentScopedServiceCounter=%d, testServiceRequestCounter=%s", applicationScopedCounter, singletonScopedCounter,requestScopedCounter,dependentScopedCounter,dependentScopedServiceCounter, requestScopedServiceCounter);
        return Response.ok(counterText).build();
    }
}
