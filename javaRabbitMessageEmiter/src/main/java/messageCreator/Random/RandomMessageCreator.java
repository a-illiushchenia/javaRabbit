package messageCreator.Random;

import messageCreator.MainMessage;
import messageCreator.MessageCreator;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomMessageCreator implements MessageCreator {

    private MainMessage mainMessage = new MainMessage();
    private int stringSize = 1;

    @Override
    public String create() {

        mainMessage.setContent(RandomStringUtils.randomAlphabetic(stringSize));
        return toJson(mainMessage);
    }

    @Override
    public void setParams(Object... params) {
        mainMessage.setOrder((int) params[0]);

       if(params.length > 1){
           stringSize = (int)params[1];
       }
    }
}
