package service;

import model.Runner;

import java.io.File;
import java.io.IOException;

public interface MainService {
  public   File createFile(String name);
  public void addRunner(Runner runner);
  public void addRunner10(File file)throws IOException;
  public void addRunner1050(File file)throws IOException;
  public void addRunner50over(File file)throws IOException;
  public String getRunnersList();
}
