package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.conversions.ArrayConverter;
import com.zipcodewilmington.streams.conversions.ListConverter;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {

        //this(Stream.empty(), null);
        this(new PersonFactory().createPersonStream(100), RandomUtils.createCharacter('A', 'Z'));
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {

        this(new ArrayConverter(people).toStream(), startingCharacter);
    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {

        this(new ListConverter(people).toStream(), startingCharacter);
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
//        return personStream.filter(
//                p -> {
//                    String firstletter = String.valueOf(p.getName().charAt(0));
//                    return firstletter.equals(this.startingCharacter);
//                }
//        ).collect(Collectors.toList());
        return personStream.filter(
                p -> {
                    String firstletter = String.valueOf(p.getName().startsWith(startingCharacter));
                    return firstletter.equals(this.startingCharacter);
                }
        ).collect(Collectors.toList());
    }

    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
        //return personStream.filter(p -> String.valueOf(p.getName().charAt(0)).equals(this.startingCharacter)).collect(Collectors.toList());
        return personStream.filter(p -> String.valueOf(p.getName().startsWith(startingCharacter)).equals(this.startingCharacter)).collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        //return personStream.filter(p -> String.valueOf(p.getName().charAt(0)).equals(this.startingCharacter)).collect(Collectors.toList()).toArray(new Person[0]);
        return personStream.filter(p -> String.valueOf(p.getName().startsWith(startingCharacter)).equals(this.startingCharacter)).collect(Collectors.toList()).toArray(new Person[0]);

    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
//        return personStream.filter(
//                p -> {
//                    String firstletter = String.valueOf(p.getName().charAt(0));
//                    return firstletter.equals(this.startingCharacter);
//                }
//        ).collect(Collectors.toList()).toArray(new Person[0]);
        return personStream.filter(
                p -> {
                    String firstletter = String.valueOf(p.getName().startsWith(startingCharacter));
                    return firstletter.equals(this.startingCharacter);
                }
        ).collect(Collectors.toList()).toArray(new Person[0]);
    }

}
