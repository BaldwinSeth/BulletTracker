package com.tests.baldwin.bullet_tracker.helpers;

import com.tests.baldwin.bullet_tracker.room_entities.Bullet;

import java.util.Arrays;
import java.util.List;

public class TagFormatter {
    public static String[] StringToTags(String tags){
        String[] temp = tags.split(",");
        for (String tag: temp) {
            tag = tag.trim();
        }
        return temp;
    }

    static public String TagsToString(String[] tags) {
        String sTags = "";
        for (String string: tags
             ) { sTags += tags+" ";
        }
        return sTags;
    }



}
