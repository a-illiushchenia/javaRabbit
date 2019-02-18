package messageCreator.Empty;

import messageCreator.MessageCreator;

public class EmptyMessageCreator implements MessageCreator {
    @Override
    public String create() {
        return "";
    }

    @Override
    public void setParams(Object... params) {

    }
}
