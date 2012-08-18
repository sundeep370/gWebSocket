package org.jwebsocket.client.plugins;

import java.util.ArrayList;

import org.jwebsocket.client.util.JsHelper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

public class RPC {

	/**
	 * Call rpc.
	 * 
	 * @param className
	 *            the class name
	 * @param methodName
	 *            the method name
	 * @param array
	 *            the array
	 * @param options
	 *            the options
	 * @return the jSON object
	 */
	public JSONObject callRPC(final String className, final String methodName,
	        final ArrayList<String> array, final JavaScriptObject options) {
		return this.doCallRPC(className, methodName, array, options);
	}

	/**
	 * Do call rpc.
	 * 
	 * @param className
	 *            the class name
	 * @param methodName
	 *            the method name
	 * @param args
	 *            the args
	 * @param options
	 *            the options
	 * @return the jSON object
	 */
	public JSONObject doCallRPC(final String className,
	        final String methodName, final ArrayList<String> args,
	        final JavaScriptObject options) {

		ArrayList<Object> serializedArgumentList = new ArrayList<Object>();

		int argCount = 1;

		for (@SuppressWarnings("unused")
		Object obj : args) {
			serializedArgumentList.add(argCount);
			argCount++;
		}

		for (Object obj : args) {
			serializedArgumentList.add(obj);
		}

		JavaScriptObject arguments = JsHelper.toJsArray(args);

		JavaScriptObject optionsObject = options;

		JavaScriptObject resultObject = RPC.callRPC(className, methodName,
		        arguments, optionsObject);

		JSONObject result = null;
		try {
			result = new JSONObject(resultObject);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	/**
	 * Call rpc.
	 * 
	 * @param className
	 *            the class name
	 * @param methodName
	 *            the method name
	 * @param array
	 *            the array
	 * @param options
	 *            the options
	 * @return the java script object
	 */
	public static native JavaScriptObject callRPC(String className,
	        String methodName, JavaScriptObject array, JavaScriptObject options)/*-{
		if (options == null) {
			options = {};
		}
		var lRes = $wnd.lWSC.rpc(className, // class
		methodName, // method
		array, options);

		return lRes;
	}-*/;

}
