package com.project.controller;

import com.project.model.serilaiztionAndDeserlization.Person;
import com.project.utils.serialization.SerializationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/do")
public class SerializationController {

    @Autowired
    private SerializationUtil serializationUtil;

    private Person dePerson;

    @GetMapping("/serialize")
    public String doSerialize() {
        try {
            SerializationUtil.serialize(new Person(25,"Unknown",150),"person.ser");
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Finished";
    }

    @GetMapping("/deserialize")
    public Person doDeserialize(){
        try{
            dePerson = (Person) SerializationUtil.deserialize("person.ser");
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return this.dePerson;
    }
}
