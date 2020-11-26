package borderControl;

public abstract class Body implements Identifiable {

    private String id;

    protected Body(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
