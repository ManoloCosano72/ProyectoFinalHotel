package com.github.ManoloCosano72.model.session;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static boolean validatePassword(String password) {
        boolean result = false;
        Pattern contrasenaPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!.#_()%*?&])[A-Za-z\\d@$!.#_()%*?&]{8,}$");
        Matcher contrasenaMatcher = contrasenaPattern.matcher(password);
        return result;
    }

    public static boolean validateMail(String mail) {
        boolean result = false;
        Pattern mailPattern = Pattern.compile("[A-Za-z0-9]+@+(gmail|outlook|hotmail)\\.(com|es)");
        Matcher mailMatcher = mailPattern.matcher(mail);
        return result;
    }
}
