class Phone extends Hardware {

    public Phone(Builder builder) {
        super(builder);
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";
    }
}