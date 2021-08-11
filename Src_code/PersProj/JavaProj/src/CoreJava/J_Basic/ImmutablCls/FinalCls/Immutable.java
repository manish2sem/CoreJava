package CoreJava.J_Basic.ImmutablCls.FinalCls;

public class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}