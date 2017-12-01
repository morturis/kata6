package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.Histogram;
import model.Mail;
import view.HistogramBuilder;
import view.HistogramDisplay;
import view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nameFile = "C:\\Users\\usuario\\Downloads\\emails.txt";
        List<Mail> listMail = MailListReader.read(nameFile);
        HistogramBuilder<Mail>	builder	= new HistogramBuilder<>(listMail);
        
        Histogram<String> domains = builder.build(new Attribute <Mail, String>(){
            @Override
            public String get(Mail item){
                //System.out.println(item.getMail());
                return item.getMail().split("@")[1];
            }
        });
        new HistogramDisplay(domains, "Dominios").execute();
        
        Histogram<Character> letters = builder.build(new Attribute <Mail, Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        new HistogramDisplay(letters, "Primer Caracter").execute();
        
    }
}
