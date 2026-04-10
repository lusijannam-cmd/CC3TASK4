class Laptop extends Hardware {

    public Laptop(Builder builder) {
        super(builder);
        this.type = "Laptop";
    }

    @Override
    public String interpretSpec() {
        return getSpec() + "GB RAM";
    }
}