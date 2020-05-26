package gen_lab04_refactoring;

public enum EnumSize {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    INVALID_SIZE("Invalid Size");


    private String size;

    EnumSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
