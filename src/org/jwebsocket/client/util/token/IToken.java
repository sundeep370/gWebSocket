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
package org.jwebsocket.client.util.token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Interface Token.
 * 
 * @author kosmal
 */
public interface IToken {

	/**
	 * Clear.
	 */
	void clear();
	  
  	/**
	 * Gets the map.
	 * 
	 * @return the map
	 */
  	Map<String,Object> getMap();
	  
  	/**
	 * Sets the map.
	 * 
	 * @param aMap
	 *            the a map
	 */
  	void setMap(HashMap<String, Object> aMap);
	  
  	/**
	 * Gets the object.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the object
	 */
  	Object getObject(String aKey);
	  
  	/**
	 * Gets the string.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the string
	 */
  	String getString(String aKey, String aDefault);
	  
  	/**
	 * Gets the string.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the string
	 */
  	String getString(String aKey);
	  
  	/**
	 * Sets the string.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setString(String aKey, String aValue);
	  
  	/**
	 * Gets the integer.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the integer
	 */
  	Integer getInteger(String aKey, Integer aDefault);
	  
  	/**
	 * Gets the integer.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the integer
	 */
  	Integer getInteger(String aKey);
	  
  	/**
	 * Sets the integer.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setInteger(String aKey, Integer aValue);
	  
  	/**
	 * Gets the long.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the long
	 */
  	Long getLong(String aKey, Long aDefault);
	  
  	/**
	 * Gets the long.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the long
	 */
  	Long getLong(String aKey);
	  
  	/**
	 * Sets the long.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setLong(String aKey, Long aValue);
	  
  	/**
	 * Gets the double.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the double
	 */
  	Double getDouble(String aKey, Double aDefault);
	  
  	/**
	 * Gets the double.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the double
	 */
  	Double getDouble(String aKey);
	  
  	/**
	 * Sets the double.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setDouble(String aKey, Double aValue);
	  
  	/**
	 * Sets the double.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setDouble(String aKey, Float aValue);
	  
  	/**
	 * Gets the boolean.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the boolean
	 */
  	Boolean getBoolean(String aKey, Boolean aDefault);
	  
  	/**
	 * Gets the boolean.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the boolean
	 */
  	Boolean getBoolean(String aKey);
	  
  	/**
	 * Sets the boolean.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aValue
	 *            the a value
	 */
  	void setBoolean(String aKey, Boolean aValue);
	  
  	/**
	 * Gets the list.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the list
	 */
  	List<?> getList(String aKey, List<?> aDefault);
	  
  	/**
	 * Gets the list.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the list
	 */
  	List<?> getList(String aKey);
	  
  	/**
	 * Sets the list.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aList
	 *            the a list
	 */
  	void setList(String aKey, List<?> aList);
	  
 	/**
	 * Sets the token.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aToken
	 *            the a token
	 */
  	void setToken(String aKey, IToken aToken);
	  
  	/**
	 * Gets the token.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the token
	 */
  	IToken getToken(String aKey);
	  
  	/**
	 * Gets the token.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the token
	 */
  	IToken getToken(String aKey, IToken aDefault);
	  
  	/**
	 * Gets the map.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aDefault
	 *            the a default
	 * @return the map
	 */
  	Map<String, Object> getMap(String aKey, Map<String,Object> aDefault);
	  
  	/**
	 * Gets the map.
	 * 
	 * @param aKey
	 *            the a key
	 * @return the map
	 */
  	Map<String, Object> getMap(String aKey);
	  
  	/**
	 * Sets the map.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aMap
	 *            the a map
	 */
  	void setMap(String aKey, Map<String, Object> aMap);
	  
  	/**
	 * Removes the.
	 * 
	 * @param aKey
	 *            the a key
	 */
  	void remove(String aKey);

	/**
	 * Put.
	 * 
	 * @param aKey
	 *            the a key
	 * @param aObject
	 *            the a object
	 */
	void put(String aKey, Object aObject);
	
}
