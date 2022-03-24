package beast_management;

public class Beast {

    private BeastType type;

    public Beast(BeastType type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }
}
