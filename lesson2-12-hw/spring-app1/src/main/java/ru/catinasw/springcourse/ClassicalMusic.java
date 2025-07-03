package ru.catinasw.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    List<String> classicalMusicList = new ArrayList<>();

    {
        classicalMusicList.add("Hungarian rhapsody 1");
        classicalMusicList.add("Hungarian rhapsody 2");
        classicalMusicList.add("Hungarian rhapsody 3");
    }


    @Override
    public List<String> getSongsList() {
        return classicalMusicList;
    }
}
