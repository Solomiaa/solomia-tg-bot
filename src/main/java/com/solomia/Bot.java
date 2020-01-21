package com.solomia;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage sendMessage= new SendMessage();

        if(command.equals("/myname")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            sendMessage.setText(update.getMessage().getFrom().getFirstName());
        }
        else {
            System.out.println("Unknown command");
        }
        sendMessage.setChatId(update.getMessage().getChatId());
        try{
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "solomia'sss_bot";
    }

    public String getBotToken() {
        return "641811670:AAGkgkg1Ak_4026gnITTRLGmuKG3vXnyP_8";
    }
}
