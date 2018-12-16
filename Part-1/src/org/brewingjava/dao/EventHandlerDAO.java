package org.brewingjava.dao;

import java.util.ArrayList;

import org.brewingjava.model.Books;

/*
 * This interface provides methods for creating events for the website
 */
public interface EventHandlerDAO {

	public boolean createEvent(ArrayList<Books> bookIdList, String eventType);

}
