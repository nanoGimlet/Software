import java.io.*;
import java.util.*;

public class PrintSplit {
    String PrintRoom = null;
    String Printsub = null;
    String Printcontent = null;
    String Printday = null;
    String Message = null;
    String Printdate = null;
    String Printmonth = null;
    String Printdayno = null;
    String Printtime = null;
    String Printyear = null;
    String Printnewday = null;
    int messlen;
    int sublen;

    public PrintSplit(String mess) {
        Message = mess;
        messlen = Message.length();
        for (int i = 0; i < messlen; i++) {
            if (Message.charAt(i) == '&') {
                if (Message.charAt(i + 1) == '#') {
                    if (Message.charAt(i + 2) == '^') {
                        PrintRoom = Message.substring(0, i);    // これは部屋の識別用
                        Printsub = Message.substring(i + 3, messlen);   // これはただのSplit用
                        break;
                    }
                }
            }
        }
        sublen = Printsub.length();
        for (int j = 0; j < sublen; j++) {
            if (Printsub.charAt(j) == '$') {
                if (Printsub.charAt(j + 1) == '!') {
                    if (Printsub.charAt(j + 2) == '+') {
                        Printcontent = Printsub.substring(0, j);    // これは肝心なメッセージ内容
                        Printday = Printsub.substring(j + 3, sublen);   // これはただのSplit用
                        break;
                    }
                }
            }
        }

        Printdate = Printday.substring(0, 3);   // これが曜日
        Printmonth = Printday.substring(4, 7);  // これが月
        Printdayno = Printday.substring(8, 10); // これが日付
        Printtime = Printday.substring(11, 19); // これが時間
        Printyear = Printday.substring(24, 28); // これが年

        switch (Printdate) {
            case "Sun":
                Printdate = "（日）";
                break;
            case "Mon":
                Printdate = "（月）";
                break;
            case "Tue":
                Printdate = "（火）";
                break;
            case "Wed":
                Printdate = "（水）";
                break;
            case "Thu":
                Printdate = "（木）";
                break;
            case "Fri":
                Printdate = "（金）";
                break;
            case "Sat":
                Printdate = "（土）";
                break;
            default:
                Printdate = null;
        }

        switch (Printmonth) {
            case "Jan":
                Printmonth = "01";
                break;
            case "Feb":
                Printmonth = "02";
                break;
            case "Mar":
                Printmonth = "03";
                break;
            case "Apr":
                Printmonth = "04";
                break;
            case "May":
                Printmonth = "05";
                break;
            case "Jun":
                Printmonth = "06";
                break;
            case "Jul":
                Printmonth = "07";
                break;
            case "Aug":
                Printmonth = "08";
                break;
            case "Sep":
                Printmonth = "09";
                break;
            case "Oct":
                Printmonth = "10";
                break;
            case "Nov":
                Printmonth = "11";
                break;
            case "Dec":
                Printmonth = "12";
                break;
            default:
                Printmonth = null;
        }

        Printnewday = Printyear + '/' + Printmonth + '/' + Printdayno + '/' + Printdate + " " + Printtime;  // ここは並び替え

    }

}
