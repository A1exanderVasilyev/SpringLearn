package ru.catinasw.springcourse;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RockMusic implements Music {
    List<String> rockMusicList = new ArrayList<>();

    {
        rockMusicList.add("Sonne 1");
        rockMusicList.add("Sonne 2");
        rockMusicList.add("Sonne 3");
    }

    @Override
    public List<String> getSongsList() {
        return rockMusicList;
    }
}
