

import java.util.Random;

public class BautistaRaquelLuckyService {
    public int hit(){
        Random rd = new Random();
        return  rd.nextInt(10);
    }
    public int getNum(){
        return hit() + hit();
    }
    public  String play(int playerNumber){
        int serverNumber = getNum();
        System.out.println("SN: " + serverNumber);

        if(getOnesDigit(serverNumber)<5){
            serverNumber += hit();
        }
        System.out.println("SN: " + serverNumber);
        System.out.println("PN: " + playerNumber);

        if(getOnesDigit(playerNumber)>getOnesDigit(serverNumber)){
            return "win";
        }else if(getOnesDigit(serverNumber)>getOnesDigit(playerNumber)){
            return "lose";
        }
        return "draw";
    }

    private int getOnesDigit(int num){
        while(num>=10){
            num = num-10;
        }
       return num;
    }
}
