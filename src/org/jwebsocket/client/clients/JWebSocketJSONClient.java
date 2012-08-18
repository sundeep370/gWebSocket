/**
 * ---------------------------------------------------------------------------
 * jWebSocket - < GWT-JSON-Client > Innotrade GmbH, Herzogenrath, Germany,
 * jWebSocket.org
 * ---------------------------------------------------------------------------
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details. You should have received a copy of
 * the GNU Lesser General Public License along with this program; if not, see
 * <http://www.gnu.org/licenses/lgpl.html>.
 * ---------------------------------------------------------------------------
 * 
 * @author Markus Kosmal (mukarev)
 */

package org.jwebsocket.client.clients;

import org.jwebsocket.client.base.JWebSocketJSON;
import org.jwebsocket.client.base.JWebSocketLogonHandler;
import org.jwebsocket.client.util.JWebSocketNotSupportedException;

/**
 * The Class JWebSocketJSONClient.
 */
public class JWebSocketJSONClient extends JWebSocketJSON {

	/** The logon handler. */
	private final JWebSocketLogonHandler logonHandler;

	/**
	 * Instantiates a new j web socket json client.
	 * 
	 * @param welcomeMessage
	 *            the welcome message
	 * @param logonHandler
	 *            the logon handler
	 * @throws JWebSocketNotSupportedException
	 *             the j web socket not supported exception
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	public JWebSocketJSONClient(final String welcomeMessage,
	        final JWebSocketLogonHandler logonHandler)
	        throws JWebSocketNotSupportedException, NullPointerException {
		super(welcomeMessage);
		if (logonHandler == null) {
			throw new NullPointerException();
		}
		this.logonHandler = logonHandler;
		if (!JWebSocketJSON.isJWebSocketSupported()) {
			throw new JWebSocketNotSupportedException();
		}
	}

	/**
	 * Gets the j web socket logon handler.
	 * 
	 * @return the j web socket logon handler
	 */
	public JWebSocketLogonHandler getJWebSocketLogonHandler() {
		return this.logonHandler;
	}

	/**
	 * Logon.
	 */
	public void logon() {

		this.logonHandler.logon();
	}

}
