package de.dapole.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrustScore {

    //Trustscore wird durch richtig parsende Angaben erhoeht

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[.][a-zA-Z]{2,6}$");

    public final Pattern VALID_DISCORD =
        Pattern.compile("[a-zA-Z]*#[0-9]{4}");

    public final Pattern VALID_PHONE =
        Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
          + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
          + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");

    public boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public boolean isFullname(String nameStr) {
        String expression = "^[a-zA-Z\\s]+";
        return nameStr.matches(expression);
    }

    public boolean checkDiscord(String discordTag) {
        Matcher matcher = VALID_DISCORD.matcher(discordTag);
        return matcher.find();
    }

    public boolean checkPhone(String phone) {
        Matcher matcher = VALID_PHONE.matcher(phone);
        return matcher.find();
    }

}
