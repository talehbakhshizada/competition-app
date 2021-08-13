/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import config.Initialization;
import java.util.Scanner;

/**
 *
 * @author 99451
 */
public class MenuUtill {
    public static void showMenu(){
         while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select menu:\n"
                    + "1.Register participant" + "\n"
                    + "2.Start game" + "\n"
                    + "3.Show points" + "\n"
                    + "4.Increase participants" + "\n"
                    + "5.Show participants" + "\n"
                    + "6.Logout"
            );

            int selectedMenu = sc.nextInt();
            
            if(selectedMenu == 1){
                ParticipantUtill.registerParticipants();
            }else if(selectedMenu==2){
                ParticipantUtill.startCompetition();
            }else if(selectedMenu==3){
                ParticipantUtill.showPoint();
            }else if(selectedMenu==4){
                ParticipantUtill.increaseParticipants();
            }else if(selectedMenu==5){
                ParticipantUtill.showParticipants(Initialization.config.getParticipants());
            }else if(selectedMenu==6){
                System.out.println("You logout.");
                System.exit(0);
            }
    }
}
}
