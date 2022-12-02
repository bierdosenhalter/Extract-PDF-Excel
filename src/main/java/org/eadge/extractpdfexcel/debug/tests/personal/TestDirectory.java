package org.eadge.extractpdfexcel.debug.tests.personal;

import org.eadge.extractpdfexcel.debug.display.FrameCreator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestDirectory {
    public static void main(String[] args) {
        Collection<String> fileNameRec = getFileNameRec("/home/ronan-j/Documents/Campus");

        ArrayList<String> pdf = new ArrayList<>();
        for (String s : fileNameRec) {
            String extension = getExtension(s);

            if (extension.equals("pdf")) {
                pdf.add(s);
            }
        }

        FrameCreator.displayDirectory("XclRenderer", 800, 600, pdf);

//        for (String s : fileNameRec)
//        {
//             if (last != null)
//            {
//                for (Iterator<JFrame> iterator = last.iterator(); iterator.hasNext(); )
//                {
//                    JFrame next = iterator.next();
//                    next.dispose();
//                }
//            }
//
//            String extension = getExtension(s);
//
//            if (extension.equals("pdf"))
//            {
//                last = PdfConverter.displayXCLPage(s);
//            }
//        }

    }

    public static Collection<String> getFileNameRec(String directory) {
        List<String> files = new ArrayList<>();
        File folder = new File(directory);

        File[] listOfFiles = folder.listFiles();
        assert listOfFiles != null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                files.add(listOfFile.getAbsolutePath());
            } else if (listOfFile.isDirectory()) {
                Collection<String> fileNameRec = getFileNameRec(listOfFile.getAbsolutePath());
                files.addAll(fileNameRec);
            }
        }
        return files;
    }

    public static String getExtension(String fileName) {
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }
}
