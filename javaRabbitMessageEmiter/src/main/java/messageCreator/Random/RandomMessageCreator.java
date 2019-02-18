package messageCreator.Random;

import messageCreator.MessageCreator;

public class RandomMessageCreator implements MessageCreator {
    private int stringSize = 1;

    @Override
    public String create() {
        return null;
    }

    @Override
    public void setParams(Object... params) {
       if(params.length > 0){
           stringSize = (int)params[0];
       }
    }
}
