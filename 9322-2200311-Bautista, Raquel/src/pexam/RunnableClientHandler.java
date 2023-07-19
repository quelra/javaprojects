package pexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.stream.IntStream;

public class RunnableClientHandler implements Runnable{
    private Socket client;
    private BufferedReader streamRdr;
    private PrintWriter streamWtr;

    public RunnableClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        streamRdr = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        streamWtr = new PrintWriter(
                clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try{
            String returnSt = "";
            String password; //1


            while(true){ //C
                password = streamRdr.readLine();
                int noDigits = 0, noLetters = 0;
                String[] chars = new String[password.length()];

                for (int i=0; i< password.length(); i++){
                    chars[i] = String.valueOf(password.charAt(i));
                }

                for (int i=0; i< chars.length; i++){
                    if(chars[i].matches("[0-9]")){
                        noDigits++;
                    }else if(chars[i].matches("[a-zA-Z]")){
                        noLetters++;
                    }
                }

                if(password.length()<6){ //2
                    streamWtr.println("maigsi");
                } else if(password.length()>12){ //2
                    streamWtr.println("mahaba");
                } else if(!password.matches("^[a-zA-Z0-9]*$")){ //3
                    streamWtr.println("may kakaibang karakter");
                } else if(noLetters>noDigits){ //4
                    streamWtr.println("maletra");
                } else if(noLetters<noDigits) { //5
                    streamWtr.println("manumero");
                } else{
                    returnSt = "katanggap-tanggap"; //6
                    streamWtr.println(returnSt);
                }

                if(returnSt.equals("katanggap-tanggap") && isPalindrome(password)){
                    streamWtr.println("paalam");
                    break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public boolean isPalindrome(String text){
        String temp = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));

    }
}
