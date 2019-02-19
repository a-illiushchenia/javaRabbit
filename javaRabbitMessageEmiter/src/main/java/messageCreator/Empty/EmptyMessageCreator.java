package messageCreator.Empty;

import messageCreator.MainMessage;
import messageCreator.MessageCreator;

public class EmptyMessageCreator implements MessageCreator {
    private MainMessage mainMessage = new MainMessage();

    @Override
    public String create() {
        mainMessage.setContent("");
        return toJson(mainMessage);
    }

    @Override
    public void setParams(Object... params) {
        mainMessage.setOrder((int) params[0]);
    }
}
