package org.example;

import net.thauvin.erik.crypto.CryptoPrice;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;

public class myBot extends TelegramLongPollingBot {
    public myBot() {
        super("8190309705:AAHMbPVNdELORnSnQEvIvHgwSpjZhoKaZ5E");}
    @Override
    public void onUpdateReceived(Update update) {
        double x = 300;
        try{var chatId = update.getMessage().getChatId();
 var message = new SendMessage();
 var text = update.getMessage().getText();
 message.setChatId(chatId);
 var BTC = CryptoPrice.spotPrice("BTC");
 var ETH = CryptoPrice.spotPrice("ETH");
 var LTC = CryptoPrice.spotPrice("LTC");
 var ETC = CryptoPrice.spotPrice("ETC");
 var DOGE = CryptoPrice.spotPrice("DOGE");
               var price = "BTC price: " + BTC.getAmount() + " USD" + "\n" +
                    "ETH price: " + ETH.getAmount() + " USD" + "\n" +
                    "LTC price: " + LTC.getAmount() + " USD" + "\n" +
                    "ETC price: " + ETC.getAmount() + " USD" + "\n" +
                    "DOGE price: " + DOGE.getAmount() + " USD" ;
                    var result=x/BTC.getAmount().doubleValue();
            switch (text) {

   case"/start"->message.setText("Hello , it's app for conversation: (BTC, ETH, LTC, ETC)");
  case "BTC"->{message.setText("BTC price: " + BTC.getAmount() + " USD");sendPicture(chatId,"OIP.png");}
  case "ETH"->{message.setText("ETH price: " + ETH.getAmount() + " USD");sendPicture(chatId, "2.jpg");}
  case"LTC"->{message.setText("LTC price: " + LTC.getAmount() + " USD");sendPicture(chatId, "3.png");}
  case "ETC"->{message.setText("ETC price: " + ETC.getAmount() + " USD");sendPicture(chatId, "4.png");}
  case "DOGE"->{message.setText("DOGE price: " + DOGE.getAmount() + " USD");sendPicture(chatId, "5.jpg");}
  case "/all"->message.setText(price);
  case "btc 300"->message.setText("BTC 300 price: " +result+ " USD");


                default->{

     var inputUser = Integer.parseInt(text);
     var resBTC = inputUser / BTC.getAmount().doubleValue();
     var resETH = inputUser / ETH.getAmount().doubleValue();
     var resLTC = inputUser / LTC.getAmount().doubleValue();
     var resETC = inputUser / ETC.getAmount().doubleValue();
     var resDOGE = inputUser / DOGE.getAmount().doubleValue();

     if (inputUser > 0) {
         message.setText("BTC: " + resBTC + "\n" + "ETH: " + resETH + "\n" +
                 "LTC: " + resLTC + "\n" + "ETC: " + resETC + "\n" + "DOGE: " + resDOGE);
     }
 else{message.setText("Enter positive number");}

 }}

            execute(message); }catch (Exception e) {
            throw new RuntimeException(e);
        }   }

void sendPicture(long chatId,String name) throws Exception {
        var photo  = getClass().getClassLoader().getResourceAsStream(name);
        var  message = new SendPhoto();
        message.setChatId(chatId);
        message.setPhoto(new InputFile(photo,name));
        execute(message);
    }


    @Override
    public String getBotUsername() {
        return "it_cool11supercool_bot";
    }
}