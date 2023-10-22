package org.fiserv.dojo.application;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class ApplicationMain {
    public static void main(String[] args){
        Quarkus.run(ApplicationController.class,args);
    }
}
