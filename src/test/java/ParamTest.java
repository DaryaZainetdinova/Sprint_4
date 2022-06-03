import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParamTest {

    private final String accountName;
    private final boolean result;

    public ParamTest(String accountName, boolean result) {
        this.accountName = accountName;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"", false}, //ввели пустое значение - ошибка
                {"по", false}, // ввели только 2 символа - ошибка
                {
                        "п о", true
                }, //ввели 3 символа (в т.ч. пробел ) - успех
                {
                        "пор пль", true
                }, // ввели 7 символов, 1 пробел - успех
                {
                        "роангвораи иротаьр", true
                }, // ввели 18 символов и 1 пробел - успех
                {
                        "порвпымвс рвпыовтыр", true
                }, // ввели  19 символов и 1 пробел - успех
                {
                        "порвпымвс рвпыовтырu", false
                }, // ввели 20 символов - ошибка
                {
                        "пллрво рлв р", false
                }, // ввели значение с 2мя пробелами - ошибка
                {
                        "рлроп", false
                }, // ввели значение без пробелов - ошибка
                {
                        " поорврп", false
                }, // начинается с пробела - ошибка
                {
                        "порорва ", false
                }, //пробел в конце - ошибка
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(accountName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(result, actual);
    }
}
