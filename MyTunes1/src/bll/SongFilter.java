/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import be.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nicklas, Kasper, Christian og Jonas
 */
public class SongFilter
{
    

    private ObservableList<Song> temp = FXCollections.observableArrayList();

    /*
    Søger gennem alle sang titler på String.
     */
    public ObservableList<Song> search(ObservableList<Song> items, String text) {
        temp.clear();
        for (Song item : items) {
            if (item.getTitle().toLowerCase().startsWith(text.toLowerCase())) {
                temp.add(item);
            }
        }
        return temp;
    }

}

