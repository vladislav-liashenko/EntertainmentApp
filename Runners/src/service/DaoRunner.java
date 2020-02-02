package service;

import model.Runner;
import sorting.MainComparator;

import java.io.*;
import java.util.*;

public class DaoRunner {

    private Set<Runner> runners = new TreeSet<>(new MainComparator());

    public void addRunner(Runner runner) {
        if (!runners.contains(runner)) {
            runners.add(runner);
        }
    }

    public void addRunner10(File file) throws IOException {
        if (!runners.isEmpty()) {
            FileWriter fileWriter = new FileWriter(file);
            int index = 1;
            for (Runner r : runners) {
                if (r.profit <= 10) {
                    fileWriter.append(index++ + "" + r.toString());
                }
            }
            fileWriter.close();
        }
    }

    public void addRunner1050(File file) throws IOException {
        if (!runners.isEmpty()) {
            FileWriter fileWriter = new FileWriter(file);
            int index = 1;
            for (Runner r : runners) {
                if (r.profit > 10 && r.profit < 50) {
                    fileWriter.append(index++ + "" + r.toString());
                }
            }
            fileWriter.close();
        }
    }
        public void addRunner50over (File file)throws IOException {
            if (!runners.isEmpty()) {
                FileWriter fileWriter = new FileWriter(file);
                int index = 1;
                for (Runner r : runners) {
                    if (r.profit > 50) {
                        fileWriter.append(index + " " + r.toString());
                    }
                }
                fileWriter.close();
            }
        }

        public String getRunnersList () {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 1;
            for (Runner runner : runners) {
                stringBuilder.append((i++) + "." + runner.fullName);
                stringBuilder.append("  " + runner.age);
                stringBuilder.append("  " + runner.profit + "\n");
            }

            return stringBuilder.toString();
        }


        public Set<Runner> getRunners () {
            return runners;
        }
        public void setRunners (Set < Runner > runners) {
            this.runners = runners;
        }
    }
