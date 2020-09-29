package be.intimals.htmlviewer;

import javax.print.attribute.standard.MediaSize;
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
    public static final String COMMENT = "cm";


    // highlight selected link
    private static String selectedLinkColorScript =
            "<script>\n" +
            "        $(document).ready(function () { \n" +
            "            $('ul.navbar-nav > li') \n" +
            "                    .click(function (e) { \n" +
            "                $('ul.navbar-nav > li') \n" +
            "                    .removeClass('active'); \n" +
            "                $(this).addClass('active'); \n" +
            "            }); \n" +
            "        });\n " +
            "</script>\n";

    // select the first link
    public static String selectTheFirstLinkScript =
            "<script type=\"text/JavaScript\">\n" +
            "       function activeLink(link){\n" +
            "           if(document.getElementById)\n" +
            "               document.getElementById(link).click();\n" +
            "           else if (document.all)\n" +
            "               document.all(link).focus();\n" +
            "        }\n " +
            "</script>\n";

    // css link style
    private static String navigateLinkColor =
            "        .nav-link { \n" +
            "            color: green; \n" +
            "        } \n" +
            "  \n" +
            "        .nav-item{ \n" +
            "           margin: 10px 0;\n" +
            "        } \n" +
            "  \n" +
            "        .navbar-nav{ \n" +
            "       list-style-type: none;\n" +
            "        } \n" +
            "  \n" +
            "        .nav-item>a:hover { \n" +
            "            color: red; \n" +
            "        } \n" +
            "  \n" +
            "        /*code to change background color*/ \n" +
            "        .navbar-nav>.active>a { \n" +
            "            background-color: #C0C0C0; \n" +
            "            color: green; \n" +
            "        } \n" +
            "   \n";


    // css colors for highlight source code
    private static String highLightColor =
            // true variable color
            "   vc{\n" +
            "       color: red;\n" +
            "       font-weight:bold;"+
            "   }\n"+
            // keyword color
            "   kc{\n" +
            "       color: #D75E0E;\n" +
            "   }\n"+
            // dummy variable color
            "   dc{\n"+
            "       color: red;\n"+
            "   }\n" +
            // comment color
            "   cm{\n"+
            "       color: #0ED7AF;\n"+
            "   }\n";

    // css color
    private static String cssContent =
            "<style>\n" +
                    navigateLinkColor +
                    highLightColor +
            "</style>\n";


    // scripts
    public static String AJAXString =
//            "<link rel = \"stylesheet\" href= \"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css\"/> \n" +
            "<script src= \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js\"> </script> \n" +
            "<script src=  \"https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js\"> </script> \n" +
            "<script src= \"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\"> </script>\n"+
                    selectedLinkColorScript +
                    selectTheFirstLinkScript ;

    // html header
    public static final String HTMLHEADER = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "   <head>\n" +
            "      <title>HTML Frames</title>\n" +
                    cssContent +
            "   </head>\n" +
            "   <body onload = \"activeLink('act');\">\n";

    public static final String HTMLCLOSE = "</body> \n" + "</html>\n";

    // python keywords
    private static String a = "=,False,None,True,and,as,assert,async,await,break,class,continue,def,del,elif,else,except,finally,for,from,global,if,import,in,is,lambda,nonlocal,not,or,pass,raise,return,try,while,with,yield";
    private static String[] list = a.split(",");
    public static final Set<String> keywords = new HashSet<>(Arrays.asList(list));


}
