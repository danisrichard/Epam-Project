package com.project.mappertest;


import com.project.model.orikamap.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SourceAndDestTests {

    private MapperFactory mapperFactory;

    @Before
    public void init() {
        this.mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @Test
    public void testGivenSourceToDestWhenMapShouldReturnSameValue() {
        mapperFactory.classMap(Source.class, Dest.class);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        Source source = new Source("Ricsko", 25);
        Dest dest = mapperFacade.map(source, Dest.class);

        assertEquals(dest.getAge(), source.getAge());
        assertEquals(dest.getName(), source.getName());
    }

    @Test
    public void testGivenSourceToDestWhenMapReverseShouldReturnSameValue() {
        mapperFactory.classMap(Source.class, Dest.class);
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        Dest dest = new Dest("Ricsko", 25);
        Source source = mapperFacade.map(dest, Source.class);

        assertEquals(source.getAge(), dest.getAge());
        assertEquals(source.getAge(), dest.getAge());
    }

    @Test
    public void testGivenSourceAndDestWhenDifferenceFieldNamesShouldMapToCorrect() {
        mapperFactory.classMap(Personne.class, Person.class)
                .field("nom", "name")
                .field("surnom", "nickname")
                .field("age", "age").register();
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        Personne personne = new Personne("Richad", "ricskooo", 25);
        Person person = mapperFacade.map(personne, Person.class);

        assertEquals(personne.getNom(), person.getName());
        assertEquals(personne.getSurnom(), person.getNickname());
        assertEquals(personne.getAge(), person.getAge());
    }

    @Test
    public void testGivenSourceAndDestWhenParseListToEntityShouldMapToCorrect() {
        mapperFactory.classMap(PersonNameList.class, PersonNameParts.class)
                .field("nameList[0]", "firstName")
                .field("nameList[1]", "lastName").register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        PersonNameList src = new PersonNameList(Arrays.asList("Richard","Danis"));
        PersonNameParts dest = mapper.map(src, PersonNameParts.class);

        assertEquals(dest.getFirstName(), "Richard");
        assertEquals(dest.getLastName(), "Danis");
    }

    @Test
    public void testGivenSourceAndDestWhenUseNestedFieldsShouldMapToCorrect(){
        mapperFactory.classMap(PersonNameContainer.class, PersonNameParts.class)
                .field("name.firstName", "firstName")
                .field("name.lastName", "lastName").register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        PersonNameContainer src = new PersonNameContainer(new Name("Rich", "Dan"));
        PersonNameParts dest = mapper.map(src, PersonNameParts.class);

        assertEquals(dest.getFirstName(), "Rich");
        assertEquals(dest.getLastName(), "Dan");
    }
}
