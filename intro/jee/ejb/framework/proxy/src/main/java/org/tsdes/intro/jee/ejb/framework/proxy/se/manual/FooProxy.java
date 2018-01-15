package org.tsdes.intro.jee.ejb.framework.proxy.se.manual;

/**
    The idea of a proxy class is that it extends the
    original one (Foo in this case), so it will have exactly
    the same methods.
    However, each call will be delegated to a private instance
    of the class we are proxying.
    But before and after each proxied call, we can do our own
    code, like starting and committing a transaction.

    Such proxy class should be automatically generated by the
    Java EE container.
    The client (ie our code) should just see a reference to Foo,
    although the actual instance is of type FooProxy.

    Note: how a Java EE does it can be quite complex, as depending
    on bytecode manipulation
 */
public class FooProxy extends Foo{

    private final Foo original;

    public FooProxy(Foo original) {
        this.original = original;
    }


    @Override
    public String someMethod(){

        // do something before
        // eg start a transaction

        String result = original.someMethod();

        //do something after
        //eg, commit the transaction
        return result;
    }
}
