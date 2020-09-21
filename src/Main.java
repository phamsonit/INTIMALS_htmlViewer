/**
 * view patterns discovered by Freqtals algorithm in web browser
 *
 * author: Hoang-Son PHAM
 */

import java.io.*;

import be.intimals.htmlviewer.*;

public class Main {

    public static void main(String[] args) {

//        args = new String[2];
//        args[0] = "/Users/user/Working/INTIMALS/softs/tree-miner/fret_java/python/sample_data/sample_input_new";
//        //args[1] = "/Users/user/Working/INTIMALS/softs/tree-miner/fret_java/python/sample_data/sample_output_new";
//        args[1] = "/Users/user/Working/INTIMALS/softs/tree-miner/fret_java/python/sample_data/sample_output_new_abstract_leaf";

        File inputSource = null;
        File inputResult;
        File outputHtmlDir;
        if (args.length != 2) {
            System.out.println("Usage:");
            System.out.println("java -jar pyConverter.jar SOURCE_DIR RESULT_DIR");
            System.out.println("SOURCE_DIR is a directory containing source files");
            System.out.println("RESULT_DIR is a directory containing results");
            System.exit(-1);
        } else
            //input source files
            inputSource = new File(args[0]);
            //input results files
            inputResult = new File(args[1]);
            //output html dir
            outputHtmlDir = new File(args[1]+"/html");
            //create html dir if it doesn't exists
            if (!outputHtmlDir.exists()) {
                outputHtmlDir.mkdir();
            } else {
                //delete all existing files
                deleteFiles(outputHtmlDir);
            }
            // create and view results in browser
            HTMLViewer htmlViewer = new HTMLViewer(inputSource, inputResult, outputHtmlDir);
            htmlViewer.view();
    }


    //delete all files in a dir
    private static void deleteFiles(File dir) {
        try {
            for (File file : dir.listFiles()) {
                if (!file.isDirectory())
                    file.delete();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
