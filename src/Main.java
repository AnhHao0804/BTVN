import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Pattern patternCreditCard;
    public static Pattern patternDate;
    public static Pattern patternTime;
    public static Matcher matcher;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Phân tích:
          4 số -> [0-9]{4}
          dấu - hoặc space -> (-| )
          => "[0-9]{4}+(-| )[0-9]{4}+(-| )[0-9]{4}+(-| )[0-9]{4}"
        */
        patternCreditCard = Pattern.compile("[0-9]{4}+(-| )[0-9]{4}+(-| )[0-9]{4}+(-| )[0-9]{4}");
        System.out.println("Mời nhập số thẻ: ");
        String numberCard = scanner.nextLine();
        while (!checkCardNumber(numberCard)){
            System.out.println("Số thẻ không đúng, mời nhập lại: ");
            numberCard = scanner.nextLine();
        }
        System.out.println("Số thẻ đúng");
        /* Phân tích Kiểm tra định dạng ngày tháng: dd/mm/yyyy
            số ngày -> [0-9]{2}
            số tháng -> [0-9]{2}
            số năm -> [0-9]{4}
            dấu / hoặc dấu - -> (/|-)
            => "[0-9]{2}(/|-)[0-9]{2}(/|-)[0-9]{4}"
        */
        patternDate = Pattern.compile("[0-9]{2}(/|-)[0-9]{2}(/|-)[0-9]{4}") ;
        System.out.println("Nhập ngày tháng năm: ");
        String date = scanner.nextLine();
        while (!checkDate(date)) {
            System.out.print("Nhập sai, mời nhập lại");
            date = scanner.nextLine();
        }
        System.out.println("Ngày đúng");
        /*Phân tích Kiểm tra giờ hợp lệ: HH:MM (HH - giờ, MM phút)
        giờ 00h tới 24h -> [00-23]{2}
        phút 00p tới 59p ->[0-5]{1}+[0-9]{1}
        dấu : -> :
        => "[0-2]{1}+[0-9]{1}+(:)+[0-5]{1}+[0-9]{1}"
    * */
        patternTime = Pattern.compile("[00-23]{2}+(:)+[0-5]{1}+[0-9]{1}");
        System.out.println("Mơì nhập giờ hiện tại: ");
        String time = scanner.nextLine();
        while (!checkTime(time)){
            System.out.print("Nhập sai, mời nhập lại: ");
            time = scanner.nextLine();
        }
        System.out.println("Giờ và phút đúng");
    }
    public static boolean checkCardNumber(String numberCard) {
        matcher = patternCreditCard.matcher(numberCard);
        return matcher.matches();
    }
    public static boolean checkDate(String date) {
        matcher = patternDate.matcher(date);
        return matcher.matches();
    }
    public static boolean checkTime(String time){
        matcher = patternTime.matcher(time);
        return matcher.matches();
    }
}