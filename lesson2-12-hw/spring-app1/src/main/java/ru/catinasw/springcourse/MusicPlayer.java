package ru.catinasw.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void playMusic(MusicGenre genre) {
        Random rand = new Random();
        String res = "Playing: ";
        List<String> musicList;
        switch (genre) {
            case CLASSICAL:
                musicList = music2.getSongsList();
                break;
            case ROCK:
                musicList = music1.getSongsList();
                break;
            default:
                throw new IllegalArgumentException("Unknown genre");
        }
        int randIndex = rand.nextInt(musicList.size());
        res += musicList.get(randIndex);
        System.out.println(res);
    }
}
