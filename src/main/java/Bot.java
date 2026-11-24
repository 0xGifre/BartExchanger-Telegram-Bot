import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    private String questionMark = "\u2753";
    private String exenchangeMark = "\u303D";
    private String calculatorMark = "\u270D";
    private String typesValute = "\u2618";
    private String dangerMark = "\u26A0";
    private String exclamationMark = "\u2757";
    private String miniBlackSquare = "\u269C";
    private String handMark = "\u270B";


    public static void main(String[] args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e){
            e.printStackTrace();
        }
    }

    public void sendMsg(Message message, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try{
            setButtons(sendMessage);
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Model model = new Model();
        if ( message != null && message.hasText()){
            switch(message.getText()){
                case "/start":
                    sendMsg(message, "Привіт друже" + handMark + " Мене звати Барт" + "\n" + "і в мене одні з найточніших курсів валют" + "\u263A" + "\n" + "\n" + exclamationMark + "Щоб ознайомитися з моїм функціоналом натисніть на клавішу    ---->   [[" + questionMark + "Допомога]]");
                    break;
                case "\u270D Калькулятор":
                    sendMsg(message, "Поки що в розробці \u23F1");
                    break;

                case "\u2753 Допомога":
                    sendMsg(message, dangerMark + "Використовуйте вбудовану клавіатуру для керування ботом." + "\n" + "\n" +
                            "[[" + calculatorMark + "Калькулятор]]" + "  -  розрахувати суму конвертованої валюти"+ "\n" + "за поточним курсом, враховуючи значення не тільки покупки "+ "\n" +"та й продажу." + "\n" + "\n" +
                            "[[" + exenchangeMark + "Курс]]" + "  -  отримати курс валюти на поточний момент" + "\n" + "\n" +
                            "[[" + typesValute + "Типи валют]]" + "  -  ознайомитися з доступними типами валют," + "\n" + "що доступні для перегляду " + "\n");
                    break;

                case "\u303D Курс":
                    sendMsg(message, "Напишіть літерний код валюти," + "\n" + "яка є актуальною у бота" + "\n" + "\n" + "Щоб знайти актуальні валюти нажміть" + "\n" +"на клавішу" + "\u27A1   " + typesValute + "Типи валют");
                    break;

                case "\u2618 Типи валют":
                    sendMsg(message, exclamationMark + "Зараз в доступі є такі валюти:" + "\n" + "\n" +
                            miniBlackSquare + "[[AUD]] - Австралийский доллар (A$)" + "\n" +
                            miniBlackSquare + "[[AZN]] - Азербайджанский манат (₼) " + "\n" +
                            miniBlackSquare + "[[GBP]] - Фунт стерлингов Соединенного королевства (£)" + "\n" +
                            miniBlackSquare + "[[AMD]] - Армянских драмов (֏)" + "\n" +
                            miniBlackSquare + "[[BYN]] - Белорусский рубль (руб.)" + "\n" +
                            miniBlackSquare + "[[BGN]] - Болгарский лев (лв.)" + "\n" +
                            miniBlackSquare + "[[BRL]] - Бразильский реал (R$)" + "\n" +
                            miniBlackSquare + "[[HUF]] - Венгерских форинтов (Ft)" + "\n" +
                            miniBlackSquare + "[[HKD]] - Гонконгских долларов (HK$)" + "\n" +
                            miniBlackSquare + "[[DKK]] - Датская крона (kr.)" + "\n" +
                            miniBlackSquare + "[[USD]] - Доллар США (US$)" + "\n" +
                            miniBlackSquare + "[[EUR]] - Евро (€)" + "\n" +
                            miniBlackSquare + "[[INR]] - Индийских рупий (₹)" + "\n" +
                            miniBlackSquare + "[[KZT]] - Казахстанских тенге (₸)" + "\n" +
                            miniBlackSquare + "[[CAD]] - Канадский доллар (CA$)" + "\n" +
                            miniBlackSquare + "[[KGS]] - Киргизских сомов (с)" + "\n" +
                            miniBlackSquare + "[[CNY]] - Китайский юань (¥)" + "\n" +
                            miniBlackSquare + "[[MDL]] - Молдавских леев (L)" + "\n" +
                            miniBlackSquare + "[[NOK]] - Норвежских крон (kr)" + "\n" +
                            miniBlackSquare + "[[PLN]] - Польский злотый (zł)" + "\n" +
                            miniBlackSquare + "[[RON]] - Румынский лей (lei)" + "\n" +
                            miniBlackSquare + "[[XDR]] - СДР (XDR)" + "\n" +
                            miniBlackSquare + "[[SGD]] - Сингапурский доллар (S$)" + "\n" +
                            miniBlackSquare + "[[TJS]] - Таджикских сомони (SM)" + "\n" +
                            miniBlackSquare + "[[TRY]] - Турецких лир (₤)" + "\n" +
                            miniBlackSquare + "[[TMT]] - Новый туркменский манат (T)" + "\n" +
                            miniBlackSquare + "[[UZS]] - Узбекских сумов (So'm)" + "\n" +
                            miniBlackSquare + "[[UAH]] - Украинских гривен (₴)" + "\n" +
                            miniBlackSquare + "[[CZK]] - Чешских крон (Kč)" + "\n" +
                            miniBlackSquare + "[[SEK]] - Шведских крон (kr)" + "\n" +
                            miniBlackSquare + "[[CHF]] - Австралийский доллар (A$)" + "\n" +
                            miniBlackSquare + "[[ZAR]] - Южноафриканских рэндов (R)" + "\n" +
                            miniBlackSquare + "[[KRW]] - Вон Республики Корея (₩)" + "\n" +
                            miniBlackSquare + "[[JPY]] - Японских иен (¥)" + "\n");

                    break;

                default:
                    try{
                        sendMsg(message, CurseValute.getCurseValute(message.getText(), model));
                    } catch (IOException e) {
                        sendMsg(message, dangerMark + "Користуйтеся клавіатурою" + "\n" +
                                "Aбо надішліть запит такого типу: USD, " + "\n" +
                                "JPY, " + "EUR !");
                    }
            }
        }
    }

    public void setButtons(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        keyboardFirstRow.add(new KeyboardButton(exenchangeMark + " Курс"));
        keyboardFirstRow.add(new KeyboardButton(typesValute + " Типи валют" ));
        keyboardSecondRow.add(new KeyboardButton(questionMark + " Допомога"));


        keyboardRowList.add(keyboardFirstRow);
        keyboardRowList.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }
    public String getBotUsername() {
        return "BartExchanger_bot";
    }

    public String getBotToken() {
        return System.getenv("TELEGRAM_BOT_TOKEN");
    }
}
