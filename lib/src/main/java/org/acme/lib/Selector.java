package org.acme.lib;

// Same shape as io.vertx.core.net.endpoint.LoadBalancer in vertx-core 5.x:
// a public interface whose constant is a lambda cast to a non-public sub-interface.
public interface Selector {

    Selector SEL = (Tagged) () -> () -> System.out.println("selected");

    Runnable select();
}
