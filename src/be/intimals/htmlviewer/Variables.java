package be.intimals.htmlviewer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Variables {
    public static final String numSep = "#";
    public static final String strSep = ";";
    public static final int nbAddedCharacters = 9;

    public static final String KEYCOLOR = "kc";
    public static final String VARCOLOR = "vc";
    public static final String DUMCOLOR = "dc";

    public static final String HTMLHEADER = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "   <head>\n" +
            "      <title>HTML Frames</title>\n" +
            "      <link rel=\"stylesheet\" href=\"link.css\">\n" +
            "   </head>\n" +
            "   <body>\n";

    public static final String HTMLCLOSE = "</body> \n" + "</html>\n";

    public static final String LINKSTYLE =
            "a {\n" +
            "  color: #2c87f0;\n" +
            "  }\n" +

//            "a:visited {\n" +
//            "  color: #636;\n" + //#636
//            "  }\n" +

            "a:hover, a:active, a:focus{\n" +
            "  color:#c33;\n" +
            "}\n" +

            //variable color
            "vc{\n" +
            "  color: red;\n" +
            "  font-weight:bold"+
            "}\n"+
            //keyword color
            "kc{\n" +
            "   color: #c33;\n" +
            "}\n"+
            //dummy variable color
            "dc{\n"+
            "  color: red;\n"+
            "}\n"
            ;

    private static String a = "=,False,None,True,and,as,assert,async,await,break,class,continue,def,del,elif,else,except,finally,for,from,global,if,import,in,is,lambda,nonlocal,not,or,pass,raise,return,try,while,with,yield";
    private static String[] list = a.split(",");
    public static final Set<String> keywords = new HashSet<>(Arrays.asList(list));


}
