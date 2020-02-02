import javafx.application.Application;
import model.Runner;
import service.MainServiceImpl;

import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args)  {

        MainServiceImpl mainService = new MainServiceImpl();

        File file10 =mainService.createFile("RunnerProfit10");
        File file1050=mainService.createFile("RunnerProfit1050");
        File fileOver50=mainService.createFile("RunnerProfitOver50");

        mainService.addRunner(new Runner("Asafa",26,9));
        mainService.addRunner(new Runner("Desta",29,9.1));
        mainService.addRunner(new Runner("Asafa",26,8.75));
        mainService.addRunner(new Runner("Bohan",23,9.99));
        mainService.addRunner(new Runner("Eo",30,9.95));
        mainService.addRunner(new Runner("Bolt",34,57));
        mainService.addRunner(new Runner("Wade",20,51));
        mainService.addRunner(new Runner("Eliud",35,47.7));
        mainService.addRunner(new Runner("Tyson",32,5.34));
        mainService.addRunner(new Runner("Vasa",35,57.7));
        mainService.addRunner(new Runner("Gorik",19,6));
        mainService.addRunner(new Runner("Jacm",22,21.21));

        try {
            mainService.addRunner10(file10);
            mainService.addRunner1050(file1050);
            mainService.addRunner50over(fileOver50);
        } catch (IOException e){
            e.printStackTrace();
        }

      System.out.println(mainService.getRunnersList());
    }

}
