package messageCreator;

import com.google.gson.Gson;

public interface MessageCreator {
    public String create();
    public void setParams(Object ... params);
    public default String toJson(Object source){
        return new Gson().toJson(source);
    }
}
