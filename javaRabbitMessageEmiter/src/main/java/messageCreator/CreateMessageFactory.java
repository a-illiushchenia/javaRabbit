package messageCreator;

import messageCreator.Empty.EmptyMessageCreator;
import messageCreator.IOCreateCampaign.IOCreateCampaignMessageCreator;
import messageCreator.Random.RandomMessageCreator;

public class CreateMessageFactory {
    public MessageCreator getMessageCreator(String creatorType){
        if (creatorType.equals("IOCreateCampaign")){
            return new IOCreateCampaignMessageCreator();
        } else if (creatorType.equals("Empty")){
            return new EmptyMessageCreator();
        } else if (creatorType.startsWith("Random")){
            return new RandomMessageCreator();
        }

        return null;
    }
}
