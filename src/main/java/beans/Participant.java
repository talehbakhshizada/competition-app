/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author 99451
 */
public class Participant implements Serializable {

    private String name;
    private String surname;
    private int age;
    static Participant[] participants;

    public Participant() {
    }

    public Participant(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return  name+" "+surname+" "+age;
                
    }

}
