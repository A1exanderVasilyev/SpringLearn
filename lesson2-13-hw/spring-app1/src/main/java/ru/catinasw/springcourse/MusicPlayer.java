package ru.catinasw.springcourse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    private List<Music> musicList;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public MusicPlayer(@Qualifier("musicList") List<Music> musicList) {
        this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();
        int musicGenreIdx = random.nextInt(musicList.size());
        return "Playing: " + musicList.get(musicGenreIdx).getSong();
    }
}
