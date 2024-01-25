package Assigment.MosicApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Album","Ac/Dc");
        album.addSong("INT",4.5);
        album.addSong("Highway to hell",3.5);
        album = new Album("Album2","Eminem");
        album.addSong("INT",4.5);
        album.addSong("Highway to hell",3.5);

        albums.add(album);

        LinkedList<Song> PlayList = new LinkedList<>();
        albums.get(0).addToPlayList("INT",PlayList);
        albums.get(1).addToPlayList("Highway to hell",PlayList);
        play(PlayList);
    }
    private static void play(LinkedList<Song> playlist){

    }
    private static void printMenu(){
        System.out.println("Available options\n");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all song\n"+
                "5 - print all available option\n"+
                "6 - delete current song");
    }
    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("----------------------\n");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
