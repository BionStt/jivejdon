/*
 * Copyright 2003-2009 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.jdon.jivejdon.event.domain.consumer.read;

import org.apache.logging.log4j.*;

import com.jdon.annotation.Consumer;
import com.jdon.async.disruptor.EventDisruptor;
import com.jdon.domain.message.DomainEventHandler;
import com.jdon.jivejdon.event.domain.consumer.write.updatemessage.MessageSaveListener;
import com.jdon.jivejdon.model.ForumMessage;
import com.jdon.jivejdon.repository.ForumFactory;

@Consumer("loadMessage")
public class Messageloader implements DomainEventHandler {
	private final static Logger logger = LogManager.getLogger(MessageSaveListener.class);

	protected ForumFactory forumAbstractFactory;

	public Messageloader(ForumFactory forumAbstractFactory) {
		super();
		this.forumAbstractFactory = forumAbstractFactory;
	}

	public void onEvent(EventDisruptor event, boolean endOfBatch) throws Exception {
		long messageId = (Long) event.getDomainMessage().getEventSource();
		try {
			ForumMessage forumMessage = forumAbstractFactory.getMessage(messageId);
			event.getDomainMessage().setEventResult(forumMessage);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}
