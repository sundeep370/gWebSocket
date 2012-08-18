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
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The Class JWebSocketJSON.
 * 
 * @author kosmal
 */
public class JWebSocketJSON extends JWebSocket {

	/**
	 * Instantiates a new jWebSocket JSON Base Class.
	 * 
	 * @param welcomeMessage
	 *            the welcome message
	 */
	public JWebSocketJSON(final String welcomeMessage) {

		this.initialize(welcomeMessage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.jwebsocket.client.base.JWebSocket#initialize(java.lang.String)
	 */
	@Override
	public void initialize(final String welcomeMessage) {
		JWebSocketJSON.initializeMe(welcomeMessage);
	}

	/**
	 * Initialize special.
	 * 
	 * @param welcomeMessage
	 *            the welcome message
	 */

	public static native void initializeMe(String welcomeMessage)/*-{
		$wnd.lWSC = new $wnd.jws.jWebSocketJSONClient({
			OnWelcome : welcomeMessage
		});

	}-*/;

	/**
	 * Broadcast.
	 * 
	 * Use it to broadcast a message to all clients.
	 * 
	 * @param broadcastMessage
	 *            the broadcast message
	 * @return the java script object
	 */
	public JavaScriptObject broadcastAllCLients(final String broadcastMessage) {
		return broadcast("", broadcastMessage);
	}

	/**
	 * Broadcast.
	 * 
	 * @param targetClients
	 *            the target clients
	 * @param broadcastMessage
	 *            the broadcast message
	 * @return the java script object
	 */
	public static native JavaScriptObject broadcast(String targetClients,
	        String broadcastMessage)/*-{
		var lRes = $wnd.lWSC.broadcastText(targetClients, // broadcast to all clients (not limited to a certain pool)
		broadcastMessage // broadcast this message
		);
		return lRes;
	}-*/;

	/**
	 * Logon.
	 * 
	 * Does the logon itself via native JavaScript.
	 * 
	 * @param url
	 *            the url of the JWebSocket-Server
	 * @param username
	 *            the username needed to logon on the url
	 * @param password
	 *            the password needed to logon on the url
	 * @param onOpenCallback
	 *            the on open callback, called when server sends an open message
	 * @param onWelcomeCallback
	 *            the on welcome callback, called when server sends a welcome
	 *            message
	 * @param onGoodByeCallback
	 *            the on good bye callback, called when server sends a goodbye
	 *            message
	 * @param onMessageCallback
	 *            the on message callback
	 * @param onCloseCallback
	 *            the on close callback, called when server sends a close
	 *            message
	 * @return the java script object the result return by the logon call
	 */
	public static native JavaScriptObject logon(String url, String username,
	        String password,
	        Callback<JavaScriptObject, JavaScriptObject> onOpenCallback,
	        Callback<JavaScriptObject, JavaScriptObject> onWelcomeCallback,
	        Callback<JavaScriptObject, JavaScriptObject> onGoodByeCallback,
	        Callback<JavaScriptObject, JavaScriptObject> onMessageCallback,
	        Callback<JavaScriptObject, JavaScriptObject> onCloseCallback) /*-{
		var openCallback = function(aEvent) {
			onOpenCallback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}

		var welcomeCallback = function(aEvent) {
			onWelcomeCallback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}

		var goodbyeCallback = function(aEvent) {
			onGoodByeCallback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}

		var messageCallback = function(aEvent, aToken) {
			onMessageCallback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aToken);
		}

		var closeCallback = function(aEvent) {
			onCloseCallback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}

		var lRes = $wnd.lWSC.logon(url, username, password, {
			OnOpen : openCallback,
			OnWelcome : welcomeCallback,
			OnGoodBye : goodbyeCallback,
			OnMessage : messageCallback,
			OnClose : closeCallback
		});
		return lRes;
	}-*/;

	/**
	 * Gets the server time.
	 * 
	 * @return the server time
	 */
	public JSONObject getServerTime(final AsyncCallback<JSONObject> aCallback) {
		Callback<JavaScriptObject, JavaScriptObject> callback = new Callback<JavaScriptObject, JavaScriptObject>() {

			@Override
			public void onSuccess(final JavaScriptObject result) {
				JSONObject lObj = JWebSocketJSON.this
				        .handleServertimeCallback(result);
				aCallback.onSuccess(lObj);
			}

			@Override
			public void onFailure(final JavaScriptObject reason) {
				Throwable lThrow = new Throwable(reason.toString());
				aCallback.onFailure(lThrow);

			}
		};
		JavaScriptObject lRes = getJSServerTime(callback);

		JSONObject lResJson = null;
		try {
			lResJson = new JSONObject(lRes);
		} catch (Exception e) {
			this.log(e.getMessage());
		}

		return lResJson;
	}

	/**
	 * Gets the server time.
	 * 
	 * @return the server time
	 */
	public JavaScriptObject getServerTimeJSO(
	        final AsyncCallback<JavaScriptObject> aCallback) {
		Callback<JavaScriptObject, JavaScriptObject> callback = new Callback<JavaScriptObject, JavaScriptObject>() {

			@Override
			public void onSuccess(final JavaScriptObject result) {
				aCallback.onSuccess(result);
			}

			@Override
			public void onFailure(final JavaScriptObject reason) {
				Throwable lThrow = new Throwable(reason.toString());
				aCallback.onFailure(lThrow);

			}
		};
		JavaScriptObject lRes = getJSServerTime(callback);

		return lRes;
	}

	protected JSONObject handleServertimeCallback(final JavaScriptObject result) {
		JSONObject lJson = null;

		try {
			lJson = new JSONObject(result);
		} catch (Exception e) {
			this.log(e.getMessage());
		}
		return lJson;

	}

	/**
	 * Gets the server time.
	 * 
	 * @return the server time
	 */
	private static native JavaScriptObject getJSServerTime(
	        Callback<JavaScriptObject, JavaScriptObject> callback)/*-{

		var aListeners = {
			OnSamplesServerTime : function(aToken) {
				callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aToken);
			}
		};

		if (aListeners.OnSamplesServerTime !== undefined) {
			$wnd.lWSC.OnSamplesServerTime = aListeners.OnSamplesServerTime;
		}

		var lRes = $wnd.lWSC.createDefaultResult();
		if ($wnd.lWSC.isConnected()) {
			//			var lToken = {
			//				ns : "jws.SamplesPlugIn.NS",
			//				type : "requestServerTime"
			//			};
			//			$wnd.lWSC.sendToken(lToken, {});
			lRes = $wnd.lWSC.requestServerTime();
		} else {
			lRes.code = -1;
			lRes.localeKey = "jws.jsc.res.notConnected";
			lRes.msg = "Not connected.";
		}

		return lRes;

	}-*/;
}
