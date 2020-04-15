package co.com.example.Repositories;

import co.com.example.Models.MessageModel;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ImplMessageRepository implements IMessageRepository {

    private List<MessageModel> messages;

    public ImplMessageRepository() {
        this.messages = new ArrayList<>();
    }

    @Override
    public MessageModel getOneMessage(String id) {
        return this.messages.stream().filter(message -> message.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<MessageModel> getAllMessages() {
        return this.messages;
    }

    @Override
    public void addMessage(MessageModel message) {
        this.messages.add(message);
    }

    @Override
    public void removeMessage(MessageModel message) {
        this.messages.remove(message);
    }

}
