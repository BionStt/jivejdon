package com.jdon.jivejdon.model.subscription.notifysubscribed;

import com.jdon.jivejdon.model.shortmessage.ShortMessage;
import com.jdon.jivejdon.model.subscription.Subscription;

public interface NotifySubscribed {

	Long getSubscribeId();

	ShortMessage createShortMessage(Subscription subscription);

}
