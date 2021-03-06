package net.engio.mbassy.listeners;

import net.engio.mbassy.listener.Handler;
import net.engio.mbassy.listener.Invoke;
import net.engio.mbassy.messages.IMultipartMessage;

/**
 *
 * @author bennidi
 *         Date: 5/24/13
 */
public class IMultipartMessageListener {

    private static abstract class BaseListener {

        @Handler
        public void handle(IMultipartMessage message){
            message.handled(this.getClass());
        }

    }

    public static class DefaultListener extends BaseListener {

        public void handle(IMultipartMessage message){
            super.handle(message);
        }
    }

    public static class NoSubtypesListener extends BaseListener {

        @Handler(rejectSubtypes = true)
        public void handle(IMultipartMessage message){
            super.handle(message);
        }
    }


    public static class AsyncListener extends BaseListener {

        @Handler(delivery = Invoke.Asynchronously)
        public void handle(IMultipartMessage message){
            super.handle(message);
        }

    }

    public static class DisabledListener extends BaseListener {

        @Handler(enabled = false)
        public void handle(IMultipartMessage message){
            super.handle(message);
        }

    }


}
