import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;


public class CurseValute {
    // http://mainavira.com/cur.json
    // 7f7ab169b19c282c234173d42efe4b73
    // https://www.cbr-xml-daily.ru/daily_json.js
    public static String getCurseValute(String message, Model model) throws IOException {
        String handMark = "\u270B";
        String whiteSquare = "\u25FD";
        String miniBlackSquare = "\u25AA";

        String ukrCharCode = " UAH";

        Double RUB = 2.7;


        String json = IOUtils.toString(new URL("https://www.cbr-xml-daily.ru/daily_json.js"), Charset.forName("UTF-8"));
        JSONObject jsonObject = new JSONObject(json);

        JSONObject firstJson = jsonObject.getJSONObject("Valute");
        JSONObject secondJson = firstJson.getJSONObject(message);
        model.setName(secondJson.getString("Name"));
        model.setCharCode(secondJson.getString("CharCode"));
        model.setValue(secondJson.getDouble("Value"));
        model.setPrevious(secondJson.getDouble("Previous"));

        Double ukrValue = model.getValue() / RUB;
        Double ukrPrevious = model.getPrevious() / RUB;

        DecimalFormat df = new DecimalFormat("##.##");


        // "\n" - next stroka
        return whiteSquare + "Світова валюта" + handMark + "\n" +
                miniBlackSquare + "Назва валюти: " + model.getName() + "\n" +
                miniBlackSquare + "Літерний код: " + model.getCharCode() + "\n" +
                miniBlackSquare + "Ціна купівлі: " + df.format(ukrValue) + ukrCharCode + "\n" +
                miniBlackSquare + "Ціна продажу: "+ df.format(ukrPrevious) + ukrCharCode;

    }
}
