public class PrintSplit {
    String PrintRoom = null;
    String Printcontent = null;
    String Printday = null;
    String Printdate = null;
    String Printmonth = null;
    String Printdayno = null;
    String Printtime = null;
    String Printyear = null;
    String Printnewday = null;
    int PrintNo = 0;

    public PrintSplit(String roomname, String mess, String date) {//クライアントからメッセージを送る形式を合わせるための下準備
        PrintRoom = roomname;
        Printcontent = mess;
        Printday = date;

    }

    public String Sendform() {//形式合わせる
        return PrintRoom + "&#^" + Printcontent + "$!+" + Printday;
    }

    public PrintSplit(String mess) {
        String tmp[] = mess.split("[&#^]");
        //for(String t : tmp )System.out.println(t);
        String tmp2[] = tmp[3].split("[$!+]");

        PrintRoom = tmp[0];
        Printcontent = tmp2[0];
        Printday = tmp2[3];

        Printdate = Printday.substring(0, 3);   // これが曜日
        Printmonth = Printday.substring(4, 7);  // これが月
        Printdayno = Printday.substring(8, 10); // これが日付
        Printtime = Printday.substring(11, 19); // これが時間
        Printyear = Printday.substring(24, 28); // これが年

        if(Printday.length() > 28) {
            if (Printday.charAt(28) == ')' && Printday.charAt(29) == '~' && Printday.charAt(30) == '|') {
                if(Printday.length() == 32) {
                    PrintNo = Character.getNumericValue(Printday.charAt(31)) + 1;
                }else if(Printday.length() == 33) {
                    PrintNo  = Integer.parseInt(Printday.substring(31, 33)) + 1;
                }else {
                    PrintNo = Integer.parseInt(Printday.substring(31, 34)) + 1;
                }
            }
        }

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