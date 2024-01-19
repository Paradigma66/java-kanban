public enum Gradation {
    NEW,
    IN_PROGRESS,
    DONE;
    private static final Gradation[] vals = values();
    public Gradation next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }
}
