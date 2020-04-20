package DatabaseFiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp_Obj {

//    public boolean valid_SignUp(Integer userId, String firstName, String lastName, String email, String phone, String pass) {
    public boolean valid_SignUp (String email, String pass){

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        System.out.println(email + " : " + matcher.matches());
        return matcher.matches();
    }
}


