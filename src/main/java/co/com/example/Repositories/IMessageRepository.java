package co.com.example.Repositories;

import co.com.example.Models.MessageModel;

import java.util.List;

public interface IMessageRepository {

    MessageModel getOneMessage(String id);
    List<MessageModel> getAllMessages();
    void addMessage(MessageModel message);
    void removeMessage(MessageModel message);

}
