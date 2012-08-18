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
package org.jwebsocket.client.plugins;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jwebsocket.client.util.token.Token;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class Tokens.
 */
public class Tokens {

	/** The logger. */
	private final Logger logger;

	/**
	 * Instantiates a new tokens.
	 * 
	 * @param logger
	 *            the logger
	 */
	public Tokens(final Logger logger) {
		this.logger = logger;
	}

	/**
	 * Send token.
	 * 
	 * @param tokens
	 *            the token
	 * @throws Exception
	 *             the exception
	 */
	public void sendToken(final Token tokens) throws Exception {
		this.log(tokens.toString());
		if (tokens.getToken() != null) {
			try {
				Tokens.sendToken(tokens.getToken());
			} catch (Exception e) {
				// this exception only occurs in debug mode - tryin to fix this
				// in the future
				e.printStackTrace();
			}
		}
	}

	/**
	 * Send token.
	 * 
	 * @param token
	 *            the token
	 * @param options
	 *            the options
	 * @throws Exception
	 *             the exception
	 */
	public void sendToken(final Token token, final JSONObject options)
	        throws Exception {
		this.log(options.toString());
		Tokens.sendToken(token.getToken(), options);
	}

	/**
	 * Send token.
	 * 
	 * @param aToken
	 *            the a token
	 * @param options
	 *            the options
	 */
	private static native void sendToken(JavaScriptObject aToken,
	        JavaScriptObject options)/*-{
		if (options == null) {
			options = {};
		}
		$wnd.lWSC.sendToken(aToken, options);
	}-*/;

	/**
	 * Send token.
	 * 
	 * @param aToken
	 *            the a token
	 */
	private static native void sendToken(JavaScriptObject aToken)/*-{
		$wnd.lWSC.sendToken(aToken, {});
	}-*/;

	/**
	 * Send token.
	 * 
	 * @param aToken
	 *            the a token
	 * @param options
	 *            the options
	 */
	private static native void sendToken(JavaScriptObject aToken,
	        JSONObject options)/*-{
		if (options == null) {
			options = {};
		}
		$wnd.lWSC.sendToken(aToken, options);
	}-*/;

	/**
	 * Send token.
	 * 
	 * @param token
	 *            the token
	 * @param array
	 *            the array
	 * @throws Exception
	 *             the exception
	 */
	public void sendToken(final Token token, final JSONArray array)
	        throws Exception {
		// log(array.toString());
		Tokens.sendToken(token.getToken(), array);
	}

	/**
	 * Send token.
	 * 
	 * @param aToken
	 *            the a token
	 * @param options
	 *            the options
	 */
	private static native void sendToken(final JavaScriptObject aToken,
	        JSONArray options)/*-{
		if (options == null) {
			options = {};
		}
		$wnd.lWSC.sendToken(aToken, options);
	}-*/;

	/**
	 * Log.
	 * 
	 * @param message
	 *            the message
	 */
	private void log(final String message) {
		this.logger.log(Level.INFO, message);
	}

}
