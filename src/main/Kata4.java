package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import model.Histogram;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\emails.txt";
        List<String> mailList= MailListReader.read(fileName);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay (histogram);
        histoDisplay.execute(); //hace visible
    }
}
