package com.swagLaps.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtiles {
    private FilesUtiles() {
        super();
    }
    public static File getLatestFile(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            LogsUtils.warn("No files found in directory: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
    }





    public static void deleteFiles(File dirPath){
        if (dirPath == null || !dirPath.exists()){
            LogsUtils.warn("Invalid directory path: " + dirPath);
            return;
        }
        File[] files = dirPath.listFiles();
        if (files == null){
          LogsUtils.warn("No files found in directory: " + dirPath);
          return;

    }
        for (File file : files) {
            if (file.isDirectory()) {
                        deleteFiles(file);
            }
             else {
                 try{
                     Files.delete(file.toPath());
                 }catch (IOException e){
                     LogsUtils.error("Failed to delete file: " + file);
                 }


            }
        }
    }
//    public static void cleanDirectory(File file ){
//        try{
//            FilesUtiles.cleanDirectory(file);
//        }catch (Exception exception){
//            LogsUtils.error(exception.getMessage());
//        }
//    }
public static void cleanDirectory(File folder) {
    try {
        if (!folder.exists() || !folder.isDirectory()) {
            LogsUtils.warn("Invalid folder: " + folder.getAbsolutePath());
            return;
        }

        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {

            if (file.isDirectory()) {
                cleanDirectory(file); // ✔️ انزل لجوا الفولدر
                file.delete();        // ✔️ امسحه بعد التفريغ
            } else {
                file.delete();        // ✔️ احذف الملف
            }
        }

    } catch (Exception e) {
        LogsUtils.error("Error cleaning directory: " + e.getMessage());
    }
}

}
