package br.letscode;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;

public class WebComQuarkusApp implements QuarkusApplication{
    @Override
    public int run(String... args) throws Exception {
        Quarkus.waitForExit();

        return 0;
    }
}
