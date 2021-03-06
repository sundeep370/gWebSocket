/**---------------------------------------------------------------------------
 * jWebSocket - < GWT-JSON-Client >
 * Innotrade GmbH, Herzogenrath, Germany, jWebSocket.org
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

/**
 * The Class JWebSocketNotSupportedException.
 *
 * @author kosmal
 */
public class JWebSocketNotSupportedException extends Exception {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5347802432010885279L;

    /**
     * Instantiates a new JWebSocketNotSupportedExceptionn.
     */
    public JWebSocketNotSupportedException(){
    	super();
    }
    
    /**
     * Instantiates a new JWebSocketNotSupportedException.
     *
     * @param message the message
     */
    public JWebSocketNotSupportedException(String message){
    	super(message);
    }
    
}
