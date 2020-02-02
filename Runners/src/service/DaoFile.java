package service;

import java.io.File;

public class DaoFile {

   private File file;

    public File createFile(String name) {

        file = new File("C:/javaEE_Projects/source/Runners/resources/" + name + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
