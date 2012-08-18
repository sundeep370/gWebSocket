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
package org.jwebsocket.client.util.token;

import java.util.Map.Entry;

import org.jwebsocket.client.util.JsHelper;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author kosmal
 * 
 */
public class Token extends BaseToken {

	public Token(final String nameSpace, final String type) {
		super(nameSpace, type);
	}

	/**
	 * Gets the token.
	 * 
	 * @return the token
	 * @throws Exception
	 */
	public JavaScriptObject getToken() throws Exception {
		JavaScriptObject lObj;

		lObj = JsHelper.toJsToken(this.getNameSpace(), this.getType(),
		        this.getDataMap());

		return lObj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		String result = "";
		try {
			result = JsHelper.toString(this.getToken());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.isEmpty()) {
			for (Entry<String, Object> entry : this.dataMap.entrySet()) {
				result += entry.getKey() + ":" + entry.getValue() + ";";
			}
		}
		return result;
	}

	public String toJsonString() {
		return "\"" + this.toString() + "\"";
	}

}
