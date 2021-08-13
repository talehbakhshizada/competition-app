/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import beans.Participant;
import beans.User;
import config.Initialization;
import java.util.Scanner;

/**
 *
 * @author 99451
 */
public class ParticipantUtill {

    public static Participant registerParticipant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter participant`name:");
        String name = sc.nextLine();

        System.out.println("Enter participant`s surname:");
        String surname = sc.nextLine();

        System.out.println("Enter participant`s age:");
        int age = sc.nextInt();

        Participant participant = new Participant(name, surname, age);

        return participant;
    }

    public static Participant[] registerParticipants() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many will you register participants?:");
        int count = sc.nextInt();
        Participant[] participants = new Participant[count];
        for (int i = 0; i < count; i++) {
            Participant participant = registerParticipant();
            participants[i] = participant;
            System.out.println("Participant added...");
        }
        System.out.println("All participants registered successfully!");
        Initialization.config.setParticipants(participants);
        return participants;
    }

    public static void increaseParticipants() {
        Scanner sc = new Scanner(System.in);
        Participant[] participantsOld = Initialization.config.getParticipants();
        if (participantsOld == null) {
            System.out.println(" Oops!\n"
                    + "Increase process failed." + "\n" + "You must first register some participants.");
            return;
        }

        System.out.println("How many will you add participants?");
        int increaseCount = sc.nextInt();

        Participant[] participantsNew = new Participant[participantsOld.length + increaseCount];

        for (int i = 0; i < participantsOld.length; i++) {
            participantsNew[i] = participantsOld[i];
        }

        for (int i = participantsOld.length; i < participantsNew.length; i++) {
            participantsNew[i] = registerParticipant();
        }

        Initialization.config.setParticipants(participantsNew);
        System.out.println("Increase process done successfully!");

    }

    public static boolean startCompetition() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter random number that between 1 and 5(including 1,5)");
        int selectNumber = sc.nextInt();

        int systemNumber = (int) Math.round(Math.random() * 5);

        if (systemNumber == selectNumber) {
            increasePoint();
            System.out.println("You won! You point increase " + "Your score: "+Initialization.config.getUser().getPoint());
            System.out.println("The number that you selected: "+selectNumber);
            System.out.println("The number that selected by system: " + systemNumber);
            return true;
        } else {
            System.out.println("Ha Ha Ha, Loser! " + Initialization.config.getUser().getPoint());
            System.out.println("The number that selected by system: " + systemNumber);
            return false;
        }
    }

    public static void increasePoint() {
        User user = Initialization.config.getUser();
        user.setPoint(user.getPoint() + 10);

    }

    public static void showPoint() {
        System.out.println("Your point: " + Initialization.config.getUser().getPoint());
    }

    public static void showParticipants(Participant[] participants) {
        if (participants == null) {
            return;
        } else {
            for (int i = 0; i < participants.length; i++) {
                Participant p = participants[i];
                System.out.println(p);
            }
        }
    }
}
