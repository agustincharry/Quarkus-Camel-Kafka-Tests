package co.com.example.Services;

import co.com.example.Models.MessageModel;
import co.com.example.Repositories.IMessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ImplMessageService implements IMessageService {

    @Inject
    IMessageRepository messageRepository;

    @Override
    public MessageModel getOneMessage(String id) {
        return this.messageRepository.getOneMessage(id);
    }

    @Override
    public List<MessageModel> getAllMessages() {
        return this.messageRepository.getAllMessages();
    }

    @Override
    public MessageModel addMessage(MessageModel message) {
        this.messageRepository.addMessage(message);
        return message;
    }

    @Override
    public MessageModel addMessage(String message) {
        MessageModel messageModel = new MessageModel(message);
        this.messageRepository.addMessage(messageModel);
        return messageModel;
    }

    @Override
    public MessageModel removeMessage(String id) {
        MessageModel message = this.getOneMessage(id);
        this.messageRepository.removeMessage(message);
        return message;
    }

}
