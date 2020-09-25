package be.intimals.htmlviewer;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import static be.intimals.htmlviewer.Variables.*;

public class Utils {

    /**
     * return index of an identifier in a string
     * @param inputString : input string
     * @param identifier : identifier needed to find index
     * @return
     */
    public static int findIdentifierIndex(String inputString, String identifier){
        int index = inputString.indexOf(identifier);
        //identifier at the beginning of the line
        if(index<=0)
            return 1;
        //find true identifier: a string lies in between 2 non-alphabet characters
        if(index + identifier.length() < inputString.length() &&
                (Character.isAlphabetic(inputString.charAt(index-1)) ||
                        Character.isAlphabetic(inputString.charAt(index+identifier.length())))){
            index += findIdentifierIndex(inputString.substring(index+1, inputString.length()), identifier) + 1;
        }else{
            ++index;
        }
        return index;
    }


    /**
     * create core html files
     * @param htmlDir : directory containing all html files
     */
    public static void  initHTMLFiles(String htmlDir){
        //create index.html file
        String indexContent =
                "<!DOCTYPE html>\n" +
                        "<html>   \n" +
                        "   <head>\n" +
                        "      <title>Patterns Visualisation</title>\n" +
                        "   </head>   \n" +
                        "   <frameset cols = \"25%,25%,50%\">\n" +
                        "      <frame name = \"left\" src = \"patterns.html\" />\n" +
                        "      <frame name = \"center\" src = \"matches.html\" />\n" +
                        "      <frame name = \"right\" src = \"sourcecode.html\" />\n" +
                        "      <noframes>\n" +
                        "         <body>Your browser does not support frames.</body>\n" +
                        "      </noframes>\n" +
                        "   </frameset>   \n" +
                        "</html>";
        String indexFile = htmlDir+"/index.html";
        writeHTML(indexFile, indexContent);

        //create matches.html file
        String matchesContent = HTMLHEADER+
                "<p><h3>Matches</h3></p>\n" +
                "\t   choose a pattern to show its matches\n" +
                HTMLCLOSE;
        String matchesFile = htmlDir+"/matches.html";
        writeHTML(matchesFile, matchesContent);

        //create sourcecode.html file
        String sourcecodeContent = HTMLHEADER+
                "<p><h3>Source code</h3></p>\n" +
                "\t  choose a match to show its source code"+
                HTMLCLOSE;
        String sourcecodeFile = htmlDir+"/sourcecode.html";
        writeHTML(sourcecodeFile, sourcecodeContent);

        //create css file
        String cssContent = LINKSTYLE;

        String cssFile = htmlDir+"/link.css";
        writeHTML(cssFile, cssContent);
    }


    /**
     * write new python code to html file
     * @param fileName : file name
     * @param content : content
     */
    public static void writeHTML(String fileName, String content){
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(content);
            file.flush();
            file.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * read xml file
     * @param fileName : name of input xml file
     * @return
     */
    public static Document readXML(String fileName){
        Document doc = null;
        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }catch (Exception e){
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * read Python source code
     * @param fileName
     * @return
     */
    public static List<String> readPyFile(String fileName){
        List<String> results = new LinkedList<>();
        try {
            Reader fileReader = new FileReader(fileName);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String line = bufReader.readLine();
            while( line != null){
                results.add(line);
                line = bufReader.readLine();
            }
        }catch (Exception e){
            System.out.println("Read python file error");
        }
        return results;
    }

    /**
     * get the last name of a path string
     * @param inputPath
     * @return
     */
    public static String getLastName(String inputPath){
        String[] temp = inputPath.split("/");
        return temp[temp.length-1];
    }

    /**
     * return full name of a match
     * @param node :
     * @return
     */
    public static String getFileNameFromMatch(Node node){
        String fullName = node.getAttributes().getNamedItem("FullName").getNodeValue();
        return Paths.get(fullName).getFileName().toString();
    }


    /**
     * find support of the pattern patternID
     * @param patternID
     * @param nodeList
     * @return
     */
    public static String findSupport(int patternID, NodeList nodeList){
        //find line number of a nodes
        for(int i=0; i<nodeList.getLength(); ++i){
            if(nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String id = nodeList.item(i).getAttributes().getNamedItem("id").getNodeValue();
                //find line and col number of this id in the doc
                if(id.equals(String.valueOf(patternID))){
                    return nodeList.item(i).getAttributes().getNamedItem("support").getNodeValue();
                }

            }
        }
        return "0-0";
    }

    /**
     * get config name from input result dir
     * @param directory
     * @return
     */
    public static String getConfigFileName(File directory){
        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".properties"));
        return files[0].getAbsolutePath();
    }

}
