class Laptop extends Hardware {

    public Laptop(Builder builder) {
        super(builder);
    }

    @Override
    public String interpretSpec() {
        return getSpec() + "GB RAM";
    }
}