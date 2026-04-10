class Phone extends Hardware {

    public Phone(Builder builder) {
        super(builder);
          this.type = "Phone";
    }

    @Override
    public String interpretSpec() {
        return getSpec() + " Megapixels";
    }
}