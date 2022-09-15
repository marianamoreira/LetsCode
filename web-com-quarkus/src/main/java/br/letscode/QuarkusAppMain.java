package br.letscode;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusAppMain {
    public static void main(String[] args) {
        Quarkus.run(WebComQuarkusApp.class, args);
    }
}
