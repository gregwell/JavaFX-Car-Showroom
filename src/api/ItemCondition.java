package api;

public enum ItemCondition {
    NEW("NEW"), USED("USED"), DAMAGED("DAMAGED");

    String value;

    ItemCondition(String value) {
        this.value =value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
