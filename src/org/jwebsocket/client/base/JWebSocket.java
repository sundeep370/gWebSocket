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
package org.jwebsocket.client.base;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;

/**
 * The Class JWebSocket.
 */
public abstract class JWebSocket {

	/** The gwt log enabled flag. */
	private boolean gwtLogEnabled = false;

	/** The logger log enabled flag. */
	private boolean loggerLogEnabled = true;

	/**
	 * Instantiates a new j web socket.
	 */
	protected JWebSocket() {

	}

	/**
	 * Initialize.
	 */
	public abstract void initialize(String welcomeMessage);

	/**
	 * Checks if is jwebsocket supported.
	 * 
	 * @return true, if is j web socket supported
	 */
	public static native boolean isJWebSocketSupported()/*-{
	                                                     return $wnd.jws.browserSupportsWebSockets();
	                                                     }-*/;

	/**
	 * Gets the default server url.
	 * 
	 * @return the default server url
	 */
	public static native String getDefaultServerURL() /*-{
	                                                  return $wnd.jws.getDefaultServerURL();
	                                                  }-*/;

	/**
	 * Log.
	 * 
	 * @param message
	 *            the message
	 */
	public void log(final String message) {
		if (this.gwtLogEnabled) {
			GWT.log(message);
		}
		if (this.loggerLogEnabled) {
			Logger.getLogger(this.getClass().getName())
			        .log(Level.INFO, message);
		}
	}

	/**
	 * Enable gwt log.
	 * 
	 * @param enabled
	 *            the enabled
	 */
	public void enableGWTLog(final boolean enabled) {
		this.gwtLogEnabled = enabled;
	}

	/**
	 * Enable logger.
	 * 
	 * @param enabled
	 *            the enabled
	 */
	public void enableLogger(final boolean enabled) {
		this.loggerLogEnabled = enabled;
	}

	/**
	 * Checks if is connected.
	 * 
	 * @return true, if is connected
	 */
	public boolean isConnected() {
		return isConnectedJS();
	}

	/**
	 * Checks if is connected.
	 * 
	 * @return true, if is connected
	 */
	private static native boolean isConnectedJS()/*-{
	                                             return $wnd.lWSC.isConnected();
	                                             }-*/;

	/**
	 * Checks if is logged in.
	 * 
	 * @return true, if is logged in
	 */
	public boolean isLoggedIn() {
		return isLoggedInJS();
	}

	/**
	 * Checks if is logged in js.
	 * 
	 * @return true, if is logged in js
	 */
	private static native boolean isLoggedInJS()/*-{
	                                            return $wnd.lWSC.isLoggedIn();
	                                            }-*/;

}