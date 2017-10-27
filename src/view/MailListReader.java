package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {
    
    public static List<String> read (String fileName) throws FileNotFoundException, IOException{
        List<String> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        while((mail=reader.readLine())!=null){
            if(mail.contains("@")){
                System.out.println("hola");
                mailList.add(mail);
            }
        }
        return mailList;
    }
}
