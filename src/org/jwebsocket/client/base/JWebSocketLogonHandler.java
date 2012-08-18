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

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

/**
 * The Class JWebSocketLogonHandler.
 * 
 * @author kosmal
 */
public abstract class JWebSocketLogonHandler {

	/** The url. */
	final String url;

	/** The username. */
	final String username;

	/** The password. */
	final String password;

	/** The connected. */
	private boolean connected;

	/** The logged on. */
	private boolean loggedOn;

	/**
	 * Instantiates a new j web socket logon handler.
	 * 
	 * @param url
	 *            the url
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public JWebSocketLogonHandler(final String url, final String username,
	        final String password) {
		this.url = url;
		if (username.equals("")) {
			this.username = "Anonymous";
		} else {
			this.username = username;
		}
		this.password = password;
	}

	/** The open callback. */
	private final Callback<JavaScriptObject, JavaScriptObject> openCallback = new Callback<JavaScriptObject, JavaScriptObject>() {

		@Override
		public void onSuccess(final JavaScriptObject result) {
			JWebSocketLogonHandler.this.handleOpenSucces(result);
			JWebSocketLogonHandler.this.setConnected(true);
		}

		@Override
		public void onFailure(final JavaScriptObject reason) {
			JWebSocketLogonHandler.this.log(reason.toString());
			JWebSocketLogonHandler.this.setConnected(false);
		}
	};

	/** The welcome callback. */
	private final Callback<JavaScriptObject, JavaScriptObject> welcomeCallback = new Callback<JavaScriptObject, JavaScriptObject>() {

		@Override
		public void onSuccess(final JavaScriptObject result) {
			JWebSocketLogonHandler.this.handleWelcomeSucces(result);
			JWebSocketLogonHandler.this.setLoggedOn(true);
		}

		@Override
		public void onFailure(final JavaScriptObject reason) {
			JWebSocketLogonHandler.this.log(reason.toString());
			JWebSocketLogonHandler.this.setLoggedOn(false);
		}
	};

	/** The goodbye callback. */
	private final Callback<JavaScriptObject, JavaScriptObject> goodbyeCallback = new Callback<JavaScriptObject, JavaScriptObject>() {

		@Override
		public void onSuccess(final JavaScriptObject result) {
			JWebSocketLogonHandler.this.handleGoodbyeSucces(result);
			JWebSocketLogonHandler.this.setLoggedOn(false);
		}

		@Override
		public void onFailure(final JavaScriptObject reason) {
			JWebSocketLogonHandler.this.log(reason.toString());
		}
	};

	/** The message callback. */
	private final Callback<JavaScriptObject, JavaScriptObject> messageCallback = new Callback<JavaScriptObject, JavaScriptObject>() {

		@Override
		public void onSuccess(final JavaScriptObject result) {
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(result);
				JWebSocketLogonHandler.this.handleMessageSucces(jsonObject);
			} catch (Exception e) {
				e.printStackTrace();
				GWT.log(JWebSocketLogonHandler.this.getClass().getName() + "\n"
				        + e.toString());
			}

		}

		@Override
		public void onFailure(final JavaScriptObject reason) {
			JWebSocketLogonHandler.this.log(reason.toString());

		}
	};

	/** The close callback. */
	private final Callback<JavaScriptObject, JavaScriptObject> closeCallback = new Callback<JavaScriptObject, JavaScriptObject>() {

		@Override
		public void onSuccess(final JavaScriptObject result) {
			JWebSocketLogonHandler.this.handleCloseSucces(result);
			JWebSocketLogonHandler.this.setConnected(false);
		}

		@Override
		public void onFailure(final JavaScriptObject reason) {
			JWebSocketLogonHandler.this.log(reason.toString());

		}
	};

	/**
	 * Log.
	 * 
	 * @param message
	 *            the message
	 * @return the string
	 */
	private String log(final String message) {
		GWT.log(message);
		return message;
	}

	/**
	 * Handle open succes.
	 * 
	 * @param event
	 *            the event
	 */
	protected abstract void handleOpenSucces(final JavaScriptObject event);

	/**
	 * Handle close succes.
	 * 
	 * @param event
	 *            the event
	 */
	protected abstract void handleCloseSucces(final JavaScriptObject event);

	/**
	 * Handle welcome succes.
	 * 
	 * @param event
	 *            the event
	 */
	protected abstract void handleWelcomeSucces(final JavaScriptObject event);

	/**
	 * Handle goodbye succes.
	 * 
	 * @param event
	 *            the event
	 */
	protected abstract void handleGoodbyeSucces(final JavaScriptObject event);

	/**
	 * Handle message succes.
	 * 
	 * @param event
	 *            the event
	 */
	protected abstract void handleMessageSucces(final JSONObject event);

	/**
	 * Logon.
	 */
	public void logon() {
		JWebSocketJSON.logon(this.url, this.username, this.password,
		        this.openCallback, this.welcomeCallback, this.goodbyeCallback,
		        this.messageCallback, this.closeCallback);
	}

	/**
	 * Checks if is connected.
	 * 
	 * @return the connected
	 */
	public final boolean isConnected() {
		return this.connected;
	}

	/**
	 * Sets the connected.
	 * 
	 * @param connected
	 *            the connected to set
	 */
	public final void setConnected(final boolean connected) {
		this.connected = connected;
	}

	/**
	 * Checks if is logged on.
	 * 
	 * @return the loggedOn
	 */
	public final boolean isLoggedOn() {
		return this.loggedOn;
	}

	/**
	 * Sets the logged on.
	 * 
	 * @param loggedOn
	 *            the loggedOn to set
	 */
	public final void setLoggedOn(final boolean loggedOn) {
		this.loggedOn = loggedOn;
	}

}
