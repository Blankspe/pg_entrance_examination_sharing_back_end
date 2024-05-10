package com.lhz.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CurrentContext {
    private static ThreadLocal<UserContext> USER_CONTEXT = new ThreadLocal<>();

    public static UserContext getContext(){
        return USER_CONTEXT.get();
    }

    public static void setContext(UserContext userContext){
        USER_CONTEXT.set(userContext);
    }

    public static Integer getUserId(){
        return USER_CONTEXT.get().getUserId();
    }

}
