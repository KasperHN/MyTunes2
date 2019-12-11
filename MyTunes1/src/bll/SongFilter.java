/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import be.SongModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kaspe
 */
public class SongFilter
{
    

    private ObservableList<SongModel> temp = FXCollections.observableArrayList();

    /*
    Searches trough all song titles and gets all items that start with specifies string
     */
    public ObservableList<SongModel> search(ObservableList<Song> items, String text) {
        temp.clear();
        for (SongModel item : items) {
            if (item.getTitle().toLowerCase().startsWith(text.toLowerCase())) {
                temp.add(item);
            }
        }
        return temp;
    }

}

