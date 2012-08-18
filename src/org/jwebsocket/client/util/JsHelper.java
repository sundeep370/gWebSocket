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

package org.jwebsocket.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jwebsocket.client.util.token.BaseToken;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ArrayHelper.
 * 
 * @author kosmal
 */
public class JsHelper {

	/**
	 * To js token.
	 * 
	 * @param namespace
	 *            the namespace
	 * @param type
	 *            the type
	 * @param map
	 *            the map
	 * @return the java script object
	 * @throws Exception
	 *             the exception
	 */
	public static JavaScriptObject toJsToken(final String namespace,
	        final String type, final Map<String, Object> map) throws Exception {
		JavaScriptObject result = JavaScriptObject.createObject();
		pushMap(result, "ns", namespace);
		pushMap(result, "type", type);
		for (Entry<String, Object> entry : map.entrySet()) {
			Object lObj = entry.getValue();
			String entryString = entry.getKey();
			if (lObj instanceof String) {
				pushMap(result, entryString, (String) lObj);
			} else if (lObj instanceof Integer) {
				pushMap(result, entryString, (Integer) lObj);
			} else if (lObj instanceof Float) {
				pushMap(result, entryString, (Float) lObj);
			} else if (lObj instanceof Double) {
				pushMap(result, entryString, (Double) lObj);
			} else if (lObj instanceof List) {
				List<?> jList = (List<?>) lObj;
				JavaScriptObject list = createArray();
				for (Object item : jList) {
					pushArray(list, item);
				}

				pushMap(result, entryString, list);
			} else if (lObj instanceof BaseToken) {
				BaseToken lToken = (BaseToken) lObj;
				JavaScriptObject lNewToken = JsHelper.toJsToken(
				        lToken.getNameSpace(), lToken.getType(),
				        lToken.getMap());
				pushMap(result, entryString, lNewToken);
			} else {
				try {

				} catch (Exception e) {
					throw e;
				}
			}

		}

		return result;
	}

	/**
	 * To js array.
	 * 
	 * @param args
	 *            the array
	 * @return the java script object
	 */
	public static JavaScriptObject toJsArray(final ArrayList<String> args) {
		JavaScriptObject result = createArray();
		for (int i = 0; i < args.size(); i++) {
			pushArray(result, args.get(i));
		}
		return result;
	};

	/**
	 * To js array.
	 * 
	 * @param array
	 *            the array
	 * @return the java script object
	 */
	public static JavaScriptObject toJsArray(final double[] array) {
		JavaScriptObject result = createArray();
		for (int i = 0; i < array.length; i++) {
			pushArray(result, array[i]);
		}
		return result;
	};

	/**
	 * To js array.
	 * 
	 * @param array
	 *            the array
	 * @return the java script object
	 */
	public static JavaScriptObject toJsArray(final Object[] array) {
		JavaScriptObject result = createArray();
		for (int i = 0; i < array.length; i++) {
			pushArray(result, array[i]);
		}
		return result;
	};

	/**
	 * Creates the map.
	 * 
	 * @return the java script object
	 */
	private native static JavaScriptObject createMap()/*-{
		var a = {};
		return a;
	}-*/;

	/**
	 * Creates the array.
	 * 
	 * @return the java script object
	 */
	private native static JavaScriptObject createArray() /*-{
		return new Array();
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        JavaScriptObject value)/*-{
		var sKey = key;
		map[sKey] = value;
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        String value)/*-{
		var sKey = key;
		map[sKey] = value;
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        Integer value)/*-{
		var lKey = key;
		var lMap = map;

		lMap[lKey] = value;
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        Float value)/*-{
		var sKey = key;
		map[sKey] = value;
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        List value)/*-{
		var sKey = key;
		map[sKey] = value;
	}-*/;

	/**
	 * Push map.
	 * 
	 * @param map
	 *            the map
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	private static native void pushMap(JavaScriptObject map, String key,
	        Double value)/*-{
		var sKey = key;
		map[sKey] = value;
	}-*/;

	/**
	 * Push array.
	 * 
	 * @param array
	 *            the array
	 * @param i
	 *            the i
	 */
	private native static void pushArray(JavaScriptObject array, int i) /*-{
		array.push(i);
	}-*/;

	/**
	 * Push array.
	 * 
	 * @param array
	 *            the array
	 * @param d
	 *            the d
	 */
	private native static void pushArray(JavaScriptObject array, double d) /*-{
		array.push(d);
	}-*/;

	/**
	 * Push array.
	 * 
	 * @param array
	 *            the array
	 * @param o
	 *            the o
	 */
	private native static void pushArray(JavaScriptObject array, Object o) /*-{
		array.push(o);
	}-*/;

	/**
	 * Creates the new callback.
	 * 
	 * @param callback
	 *            the callback
	 * @return the java script object
	 */
	public JavaScriptObject createNewCallback(
	        final Callback<JavaScriptObject, JavaScriptObject> callback) {

		return getJSCallback(callback);
	}

	/**
	 * Creates the on response callback.
	 * 
	 * @param callback
	 *            the callback
	 * @return the java script object
	 */
	public static native JavaScriptObject createOnResponseCallback(
	        Callback<JavaScriptObject, JavaScriptObject> callback)/*-{
		var newCallback = function(aEvent) {
			callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}

		var onResponseCallback = {
			onResponse : newCallback
		}

		return onResponseCallback;
	}-*/;

	/**
	 * Gets the jS callback.
	 * 
	 * @param callback
	 *            the callback
	 * @return the jS callback
	 */
	public static native JavaScriptObject getJSCallback(
	        Callback<JavaScriptObject, JavaScriptObject> callback) /*-{
		var newCallback = function(aEvent) {
			callback.@com.google.gwt.core.client.Callback::onSuccess(Ljava/lang/Object;)(aEvent);
		}
		return newCallback;
	}-*/;

	/**
	 * Creates the json array.
	 * 
	 * @param arr
	 *            the arr
	 * @return the jSON array
	 */
	public static JSONArray createJSONArray(final JavaScriptObject arr) {

		JSONArray array = new JSONArray(arr);

		return array;
	}

	/**
	 * To string.
	 * 
	 * @param target
	 *            the target
	 * @return the string
	 */
	public static String toString(final JavaScriptObject target) {

		JSONObject lObj = new JSONObject(target);
		if (!lObj.toString().isEmpty()) {
			return lObj.toString();
		} else {
			return target.toString();
		}
	}

}
