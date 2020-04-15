package co.com.example.Services;

import co.com.example.Models.MessageModel;

import java.util.List;

public interface IMessageService {

    MessageModel getOneMessage(String id);
    List<MessageModel> getAllMessages();
    MessageModel addMessage(MessageModel message);
    MessageModel removeMessage(String id);

}
