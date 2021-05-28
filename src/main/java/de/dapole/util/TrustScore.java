package de.dapole.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrustScore {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public final Pattern VALID_DISCORD =
        Pattern.compile("[a-zA-Z]*#[0-9]{4}");

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

    /* public int checkPhone() {


    } */

}
