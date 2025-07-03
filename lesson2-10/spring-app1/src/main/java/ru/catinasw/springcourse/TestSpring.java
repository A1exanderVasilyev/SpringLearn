package ru.catinasw.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassicalMusic music = context.getBean("classicalMusic", ClassicalMusic.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

        RockMusic rockMusic = context.getBean("rockMusic", RockMusic.class);
        MusicPlayer musicPlayer2 = new MusicPlayer(rockMusic);
        musicPlayer2.playMusic();

        context.close();
    }
}