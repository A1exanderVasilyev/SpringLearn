package ru.catinasw.springcourse;

public class ClassicalMusic implements Music {
    private ClassicalMusic() {}

    public static ClassicalMusic getClassicalMusic() {
        return new ClassicalMusic();
    }

    @Override
    public String getSong() {
        return "Hungarian rhapsody";
    }

    public void doMyInit() {
        System.out.println("Doing my init");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destroy");
    }
}
