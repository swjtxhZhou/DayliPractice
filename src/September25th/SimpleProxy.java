package September25th;

public class SimpleProxy implements Interface{
    private Interface proxied;

    public SimpleProxy(Interface proxied){this.proxied = proxied;}


    @Override
    public void doSomething() {
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        proxied.somethingElse(args);
    }
}
