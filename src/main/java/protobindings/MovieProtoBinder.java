package protobindings;

import com.example.proto.Accolades;
import com.example.proto.Artist;
import com.example.proto.AwardCategory;
import com.example.proto.Date;
import com.example.proto.Genre;
import com.example.proto.Movie;
import com.example.proto.Person;
import com.example.proto.Time;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MovieProtoBinder {
    public static Person person(String name, Person.Gender gender, Date dateOfBirth) {
        return Person.newBuilder()
                .setName(name)
                .setDateOfBirth(dateOfBirth)
                .setAge(getAge(dateOfBirth))
                .setGender(gender)
                .build();
    }

    public static int getAge(Date dateOfBirth) {
        int age = 0;
        if (dateOfBirth != null) {
            LocalDate now = LocalDate.now();
            LocalDate dob = LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDay());
            age = Period.between(dob, now).getYears();
        }
        return age;
    }

    public static Artist artist(Person person, int accolades) {
        return Artist.newBuilder()
                .setPerson(person)
                .setAccolades(accolades)
                .build();
    }

    public static Accolades accolades(String accoladeName, AwardCategory categoryName,
                                      List<Person> people, Accolades.Status status) {
        return Accolades.newBuilder()
                .setAccoladeName(accoladeName)
                .setCategoryName(categoryName)
                .addAllPeople(people)
                .setStatus(status)
                .build();
    }

    public static Date date(int day, int month, int year) {
        Date.Builder builder = Date.newBuilder();
        if (day > 0) {
            builder.setDay(day);
        }
        if (month > 0) {
            builder.setMonth(month);
        }
        if (year > 0) {
            builder.setYear(year);
        }
        return builder
                .build();
    }

    public static Time time(int hours, int minutes, int seconds) {
        Time.Builder builder = Time.newBuilder();
        builder.setHours(hours);
        builder.setMinutes(minutes);
        builder.setSeconds(seconds);
        return builder
                .build();
    }

    public static Movie movie(String title, List<Artist> directors, List<Artist> cast,
                              Time runTime, Date releaseDate, List<String> productionHouses,
                              List<String> vfxStudios, List<Artist> musicDirectors,
                              List<Accolades> accolades, List<Genre> genres,
                              float boxOffice) {
        return Movie.newBuilder()
                .setTitle(title)
                .addAllDirectors(directors)
                .addAllCast(cast)
                .setRuntime(runTime)
                .setReleaseDate(releaseDate)
                .addAllProductionHouses(productionHouses)
                .addAllVfxStudios(vfxStudios)
                .addAllMusicDirectors(musicDirectors)
                .addAllAccolades(accolades)
                .addAllGenres(genres)
                .setBoxoffice(boxOffice)
                .build();
    }
}