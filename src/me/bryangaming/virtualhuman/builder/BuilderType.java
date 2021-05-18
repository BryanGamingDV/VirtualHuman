package me.bryangaming.virtualhuman.builder;

public enum BuilderType {
    TWO(2, 1),
    FIVE(5, 2),
    TEN(10, 3),
    TWENTY(20, 4),
    FIFTY(50, 5);                                                                                                                                               ;

    private final int numberRequeriment;
    private final int builderTimes;

    BuilderType(int numberRequeriment, int builderTimes){
        this.numberRequeriment = numberRequeriment;
        this.builderTimes = builderTimes;
    }

    public int getNumberRequeriment() {
        return numberRequeriment;
    }

    public int getBuilderTimes() {
        return builderTimes;
    }
}
