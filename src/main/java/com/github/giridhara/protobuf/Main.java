package com.github.giridhara.protobuf;


import com.example.proto.Accolades;
import com.example.proto.Artist;
import com.example.proto.AwardCategory;
import com.example.proto.Date;
import com.example.proto.Genre;
import com.example.proto.Movie;
import com.example.proto.Person;
import com.example.proto.Time;

import java.util.Arrays;
import java.util.List;

import static protobindings.MovieProtoBinder.accolades;
import static protobindings.MovieProtoBinder.artist;
import static protobindings.MovieProtoBinder.date;
import static protobindings.MovieProtoBinder.movie;
import static protobindings.MovieProtoBinder.person;
import static protobindings.MovieProtoBinder.time;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running protobuf-gradle!!!");
        System.out.println("List of Movies:");
        Person keanuReeves = person("Keanu Reeves", Person.Gender.MALE, date(2, 9, 1952));
        Person laurenceFishburne = person("Laurence Fishburne", Person.Gender.MALE, date(30, 7, 1961));
        Person carrieMoss = person("Carrie-Anne Moss", Person.Gender.FEMALE, date(21, 8, 1967));
        Person lanaWachowski = person("Lana Wachowski", Person.Gender.TRANS, date(21, 6, 1965));
        Person lillyWachowski = person("Lilly Wachowski", Person.Gender.TRANS, date(29, 12, 1967));
        Person donDavis = person("Don Davis", Person.Gender.MALE, date(4, 2, 1957));
        Person zachStenberg = person("Zach Stenberg", Person.Gender.MALE, date(1, 1, 1954));
        Person daneADavis = person("Dane A. Davis", Person.Gender.MALE, date(1, 1, 1953));

        Artist artistKeanuReeves = artist(keanuReeves, 46);
        Artist artistCarrieMoss = artist(carrieMoss, 14);
        Artist artistLaurenceFishburne = artist(laurenceFishburne, 99);
        Artist artistLanaWachowski = artist(lanaWachowski, 37);
        Artist artistLillyWachowski = artist(lillyWachowski, 36);
        Artist artistDonDavis = artist(donDavis, 15);

        List<Artist> directors = Arrays.asList(artistLanaWachowski, artistLillyWachowski);
        List<Artist> cast = Arrays.asList(artistKeanuReeves, artistLaurenceFishburne, artistCarrieMoss);
        Time runTime = time(2, 16, 0);
        Date releaseDate = date(31, 3, 1999);
        List<String> productionHouses = Arrays.asList("WB");
        List<String> vfxStudios = Arrays.asList("WB");
        List<Artist> musicDirectors = Arrays.asList(artistDonDavis);
        List<Accolades> accolades = Arrays.asList(
                accolades("Oscar", AwardCategory.BEST_FILM_EDITING, Arrays.asList(zachStenberg),
                        Accolades.Status.WON),
                accolades("Oscar", AwardCategory.BEST_EFFECTS_SOUND_EFFECTS_EDITING, Arrays.asList(daneADavis),
                        Accolades.Status.WON));
        Movie movie = movie("The Matrix", directors, cast, runTime, releaseDate, productionHouses,
                vfxStudios, musicDirectors, accolades, Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION), 466364845);
        System.out.println(movie);
    }

}
