package service;

import model.Runner;
import java.io.File;
import java.io.IOException;


public class MainServiceImpl implements MainService {
    DaoFile daoFile = new DaoFile();
    DaoRunner daoRunner=new DaoRunner();

    public MainServiceImpl() {
    }

    @Override
    public File createFile(String name) {
        return daoFile.createFile(name);
    }

    @Override
    public void addRunner(Runner runner) {
    daoRunner.addRunner(runner);
    }

    @Override
    public void addRunner10(File file)throws IOException{
        daoRunner.addRunner10(file);
    }

    @Override
    public void addRunner1050(File file)throws IOException {
    daoRunner.addRunner1050(file);
    }

    @Override
    public void addRunner50over(File file)throws IOException {
    daoRunner.addRunner50over(file);
    }
    @Override
    public String getRunnersList() {
        return daoRunner.getRunnersList();
    }


}
