import org.apache.commons.lang3.StringUtils;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        int spaseCount = StringUtils.countMatches(name, " ");

        if ((name.length() >= 3) && (name.length() <= 19) && (spaseCount == 1) && (name.indexOf(" ") > 0) && (name.indexOf(" ") != (name.length() - 1))) {
            return true;
        } else {
            return false;
        }
    }
}






