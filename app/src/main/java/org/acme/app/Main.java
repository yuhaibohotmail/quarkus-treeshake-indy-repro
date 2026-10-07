package org.acme.app;

import org.acme.lib.Selector;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Override
    public int run(String... args) {
        Selector.SEL.select().run();
        return 0;
    }
}
