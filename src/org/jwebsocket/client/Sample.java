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

package org.jwebsocket.client;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.jwebsocket.client.base.JWebSocketLogonHandler;
import org.jwebsocket.client.clients.JWebSocketJSONClient;
import org.jwebsocket.client.plugins.FileSystem;
import org.jwebsocket.client.plugins.RPC;
import org.jwebsocket.client.plugins.Tokens;
import org.jwebsocket.client.util.JWebSocketNotSupportedException;
import org.jwebsocket.client.util.JsHelper;
import org.jwebsocket.client.util.token.Token;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * The Class Sample.
 * 
 * Here you can see an example for using the GWT jWebSocket Client.
 * 
 * @author kosmal
 */
public class Sample implements EntryPoint {

	/**
	 * The output div. Here we can see the output of information log.
	 * */
	FlowPanel outputDiv;

	/**
	 * The scroll panel. Makes us able to scroll through the output
	 * */
	ScrollPanel scrollPanel;

	/**
	 * The container. Container for the sample's buttons and the output.
	 * */
	FlowPanel container;

	/**
	 * The JSONClient.
	 * 
	 * Instance of the JWebSocketJSONClient to deal with.
	 * */
	JWebSocketJSONClient jsonClient;

	/** The header panel. */
	FlowPanel headerPanel;

	/**
	 * The logon handler.
	 * 
	 * Instance of the JWebSocketLogonHandler. Here you can do the logon and
	 * handle the different callbacks.
	 * */
	JWebSocketLogonHandler logonHandler;

	/** The user name text box. */
	private final TextBox userNameTextBox;

	/** The password text box. */
	private final PasswordTextBox passwordTextBox;

	/** The url text box. */
	private final TextBox urlTextBox;

	/** The connect button. */
	// private final Button connectButton;

	private final Button logonButton;

	private final RPC rpcPlugin = new RPC();
	private final FileSystem fileSystemPlugin = new FileSystem(
	        Logger.getLogger("FileSystemPlugin"));
	private final Tokens tokens = new Tokens(Logger.getLogger("TokensPlugin"));

	/*
	 * #######################--- CONSTRUCTOR ---##############################
	 */

	/**
	 * Instantiates a new sample.
	 */
	public Sample() {

		this.outputDiv = new FlowPanel();
		this.headerPanel = new FlowPanel();

		this.userNameTextBox = new TextBox();
		this.userNameTextBox.setText("guest");
		this.userNameTextBox.setEnabled(false);

		this.passwordTextBox = new PasswordTextBox();
		this.passwordTextBox.setText("guest");
		this.passwordTextBox.setEnabled(false);

		this.urlTextBox = new TextBox();
		this.urlTextBox
		        .setText("ws://pear-webdesign-agentur.de:8787/jwebsocket/jwebsocket");

		// this.connectButton = new Button("Connect");
		this.logonButton = new Button("Connect");

		Image img = new Image("logo.png");
		img.setStyleName("logo");
		img.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Window.open("http://www.jwebsocket.org", "_blank", "");

			}
		});
		RootPanel.get().add(img);

	}

	/*
	 * #######################--- MODULE-LOAD---##############################
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.core.client.EntryPoint#onModuleLoad()
	 */
	@Override
	public void onModuleLoad() {

		FlowPanel connectAndLogonPanel = new FlowPanel();

		FlowPanel connectPanel = new FlowPanel();

		// create url textbox
		HTML connectURL = new HTML("ConnectURL");
		connectPanel.add(connectURL);
		connectPanel.add(this.urlTextBox);

		// connectPanel.add(this.connectButton);

		FlowPanel logonPanel = new FlowPanel();

		// create user name textbox
		HTML nameLabel = new HTML("UserName");
		logonPanel.add(nameLabel);
		logonPanel.add(this.userNameTextBox);

		// create password textbox
		HTML pwLabel = new HTML("Password");
		logonPanel.add(pwLabel);
		logonPanel.add(this.passwordTextBox);

		logonPanel.add(this.logonButton);

		connectAndLogonPanel.add(connectPanel);
		connectAndLogonPanel.add(logonPanel);

		this.setLeftToChildren(connectPanel);
		this.setLeftToChildren(logonPanel);
		this.setLeftToChildren(connectAndLogonPanel);

		connectAndLogonPanel.setWidth("100%");

		RootPanel.get("head").add(connectAndLogonPanel);

		// create sample buttons and output container
		this.container = new FlowPanel();
		this.container.setStyleName("con");
		this.headerPanel.setSize("100%", "45px");
		this.scrollPanel = new ScrollPanel(this.outputDiv);
		int height = Window.getClientHeight() - 125;
		this.scrollPanel.setSize("100%", height + "px");
		this.scrollPanel.setStyleName("scroll");
		this.container.add(this.headerPanel);
		this.container.add(this.scrollPanel);

		RootPanel.get().add(this.container);

		this.initButtons();
		this.enableSampleButtons(false);
		// this.connectButton.addClickHandler(new ClickHandler() {
		//
		// @Override
		// public void onClick(final ClickEvent event) {
		//
		// }
		// });

		this.logonButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				Sample.this.connect();
				Sample.this.logon();
			}
		});

	}

	/* ############################--- CONNECT ---############################## */

	/**
	 * Connect.
	 */
	private void connect() {
		if (this.jsonClient == null || !this.jsonClient.isConnected()) {
			this.logonHandler = new JWebSocketLogonHandler(
			        // "ws://pear-webdesign-agentur.de:8787", //
			        // /jWebSocket/jWebSocket
			        // "root",
			        // "root"
			        this.urlTextBox.getText(), this.userNameTextBox.getText(),
			        this.passwordTextBox.getText()) {

				@Override
				protected void handleWelcomeSucces(final JavaScriptObject event) {
					Sample.this.logOutput("Welcome from Serverrecieved");
					Sample.this.enableSampleButtons(true);

				}

				@Override
				protected void handleOpenSucces(final JavaScriptObject event) {
					Sample.this.logOutput("Connection to server established");
					Sample.this.enableLogon();
				}

				@Override
				protected void handleMessageSucces(final JSONObject event) {
					Sample.this.logOutput(event.toString());
				}

				@Override
				protected void handleGoodbyeSucces(final JavaScriptObject event) {
					Sample.this.logOutput("Server Goodbye recieved");
					Sample.this.enableSampleButtons(false);
				}

				@Override
				protected void handleCloseSucces(final JavaScriptObject event) {
					JSONObject lObj = new JSONObject(event);
					Sample.this.logOutput(lObj.toString());
					Sample.this.logOutput("Server closed connection");
					Sample.this.enableSampleButtons(false);
				}
			};
			// this.logOutput("Tryin to connect to " +
			// this.urlTextBox.getText());
			try {
				this.jsonClient = new JWebSocketJSONClient("Hallo",
				        this.logonHandler);
			} catch (JWebSocketNotSupportedException e) {
				e.printStackTrace();
			}

			if (this.jsonClient != null) {
				this.jsonClient.enableGWTLog(true);
				this.jsonClient.enableLogger(true);
			}
		} else {
			this.logOutput("Client connected");
		}
	}

	private void logon() {
		if (!this.jsonClient.isLoggedIn()) {
			this.logonHandler.logon();
			this.logOutput("Tryin to logon to " + this.urlTextBox.getText()
			        + " with username " + this.userNameTextBox.getText());
			Sample.this.enableSampleButtons(true);
		}

	}

	/*
	 * #######################--- INIT-BUTTONS ---##############################
	 */

	/**
	 * Inits the buttons.
	 */
	private void initButtons() {
		Button sampleRPCButton = new Button("SampleRPC");
		sampleRPCButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleRPC();

			}
		});
		this.headerPanel.add(sampleRPCButton);

		Button sampleBroadcastButton = new Button("SampleBroadcast");
		sampleBroadcastButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleBroadcast();
			}
		});
		this.headerPanel.add(sampleBroadcastButton);

		Button sampleTokenSendButton = new Button("SampleTokenSend");
		sampleTokenSendButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleTokenSend();
			}
		});
		this.headerPanel.add(sampleTokenSendButton);

		Button sampleTokenizable = new Button("SampleTokenizable");
		sampleTokenizable.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleTokenizable();

			}
		});
		// headerPanel.add(sampleTokenizable);

		Button sampleGetFileList = new Button("SampleGetFileList");
		sampleGetFileList.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleGetFileList();

			}
		});
		this.headerPanel.add(sampleGetFileList);

		Button sampleServerTime = new Button("GetServerTime");
		sampleServerTime.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.sampleServerTime();

			}
		});
		this.headerPanel.add(sampleServerTime);

		// ------- the following should be last

		Button clearLog = new Button("ClearLog");
		clearLog.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				Sample.this.outputDiv.clear();
			}
		});
		this.headerPanel.add(clearLog);

		for (int i = 0; i < this.headerPanel.getWidgetCount(); i++) {
			if (this.headerPanel.getWidget(i) instanceof Button) {
				Button button = (Button) this.headerPanel.getWidget(i);
				button.setEnabled(false);
			}
		}

	}

	/*
	 * ##################--- SAMPLE METHODS ---##############################
	 */

	/**
	 * Sample server time.
	 */
	public void sampleServerTime() {

		// AsyncCallback<JSONObject> sampleTimeCallback = new
		// AsyncCallback<JSONObject>() {
		//
		// @Override
		// public void onSuccess(final JSONObject result) {
		//
		// JSONArray lArray = result.isArray();
		// if (lArray == null) {
		// Sample.this.logOutput(result.toString());
		// } else {
		// for (int i = 0; i < lArray.size(); i++) {
		// Sample.this.logOutput(lArray.get(i).toString());
		// }
		// }
		// }
		//
		// @Override
		// public void onFailure(final Throwable caught) {
		// Sample.this.logOutput(caught.getMessage());
		//
		// }
		// };

		AsyncCallback<JavaScriptObject> sampleTimeCallback = new AsyncCallback<JavaScriptObject>() {

			@Override
			public void onSuccess(final JavaScriptObject result) {

				JSONObject lObj = new JSONObject(result);

				JSONArray lArray = lObj.isArray();
				if (lArray == null) {
					Sample.this.logOutput(lObj.toString());
					Sample.this.logOutput(result.toString());
				} else {
					for (int i = 0; i < lArray.size(); i++) {
						Sample.this.logOutput(lArray.get(i).toString());
					}
				}
			}

			@Override
			public void onFailure(final Throwable caught) {
				Sample.this.logOutput(caught.getMessage());

			}
		};

		JavaScriptObject time = this.jsonClient
		        .getServerTimeJSO(sampleTimeCallback);
		this.logOutput(time.toString());
	}

	/**
	 * Sample rpc.
	 */
	public void sampleRPC() {
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		testList.add("d");

		JSONObject jsonObject = this.rpcPlugin.callRPC(
		        "org.jwebsocket.rpc.sample.SampleRPCLibrary", "runListDemo",
		        testList, null);
		this.logOutput(jsonObject.toString());
	}

	/**
	 * Sample broadcast.
	 */
	public void sampleBroadcast() {
		this.jsonClient.broadcastAllCLients("Sample broadcast from "
		        + Navigator.getPlatform() + " " + GWT.getHostPageBaseURL()
		        + "-" + Window.getTitle());
	}

	/**
	 * Sample token send.
	 */
	public void sampleTokenSend() {
		Token token = new Token("jws.SamplesPlugIn.NS", "processComplexObject");
		token.put("int_val", 1234);
		token.put("myDouble", 12.34);
		try {
			this.tokens.sendToken(token);
		} catch (Exception e) {
			this.logOutput(e.getMessage());
			e.printStackTrace();
		}
		this.logOutput(token.toString());
	}

	/**
	 * Sample tokenizable.
	 */
	public void sampleTokenizable() {
		Token token = new Token("my.namespace", "getTokenizable");

		Callback<JavaScriptObject, JavaScriptObject> callback = new Callback<JavaScriptObject, JavaScriptObject>() {

			@Override
			public void onSuccess(final JavaScriptObject result) {
				Sample.this.logOutput(result.toString());

			}

			@Override
			public void onFailure(final JavaScriptObject reason) {
				Sample.this.logOutput(reason.toString());

			}
		};

		JavaScriptObject responseCallback = JsHelper.getJSCallback(callback);

		JSONArray array = JsHelper.createJSONArray(responseCallback);
		this.logOutput(array.toString());
		try {
			this.tokens.sendToken(token, array);
		} catch (Exception e) {
			this.logOutput(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Sample get file list.
	 */
	private void sampleGetFileList() {
		JSONObject lObj = this.fileSystemPlugin.getFileList("publicDir", "*.*",
		        true);

		if (lObj != null) {
			this.logOutput(lObj.toString());
		}
	}

	/* ############################---UTIL---############################## */

	/**
	 * Log output.
	 * 
	 * @param message
	 *            the message
	 */
	private void logOutput(final String message) {
		if (message != null) {
			this.outputDiv.add(new HTML(message));
			this.scrollPanel.scrollToBottom();
		}
	}

	/**
	 * Sets the left to children.
	 * 
	 * @param container
	 *            the new left to children
	 */
	private void setLeftToChildren(final FlowPanel container) {
		for (int i = 0; i < container.getWidgetCount(); i++) {
			container.getWidget(i).addStyleName("left");
		}
	}

	/**
	 * Enable logon.
	 */
	private void enableLogon() {
		Sample.this.logonButton.setText("Logon");
		Sample.this.userNameTextBox.setEnabled(true);
		Sample.this.passwordTextBox.setEnabled(true);
	}

	/**
     * 
     */
	private void enableSampleButtons(final boolean enable) {
		for (int i = 0; i < Sample.this.headerPanel.getWidgetCount(); i++) {
			if (Sample.this.headerPanel.getWidget(i) instanceof Button) {
				Button button = (Button) Sample.this.headerPanel.getWidget(i);
				button.setEnabled(enable);
			}
		}
	}

}
