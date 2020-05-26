package gen_lab04_refactoring;

public enum EnumColor {
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow"),
    NO_COLOR("no color");

    private String color;

    EnumColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
