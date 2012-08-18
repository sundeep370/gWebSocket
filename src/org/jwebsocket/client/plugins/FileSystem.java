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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class FileSystem.
 */
public class FileSystem {

	/** The logger. */
	private final Logger logger;

	/**
	 * Instantiates a new file system.
	 * 
	 * @param logger
	 *            the logger
	 */
	public FileSystem(final Logger logger) {
		this.logger = logger;
	}

	/**
	 * Gets the file list.
	 * 
	 * @param path
	 *            the path
	 * @param pattern
	 *            the pattern
	 * @param recursive
	 *            the recursive
	 * @return the file list
	 */
	public JSONObject getFileList(final String path, final String pattern,
	        final boolean recursive) {

		JavaScriptObject lObj = getFileListJS(path, pattern, recursive);
		JSONObject lJson = null;
		try {
			lJson = new JSONObject(lObj);
		} catch (Exception e) {
			this.log(e.getMessage());
		}

		return lJson;
	}

	/**
	 * Gets the file list js.
	 * 
	 * @param path
	 *            the path
	 * @param pattern
	 *            the pattern
	 * @param recursive
	 *            the recursive
	 * @return the file list js
	 */
	private static native JavaScriptObject getFileListJS(String path,
	        String pattern, boolean recursive)/*-{

		var lRes = $wnd.lWSC.fileGetFilelist(path, [ pattern ], {
			recursive : recursive
		});

		return lRes;
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
