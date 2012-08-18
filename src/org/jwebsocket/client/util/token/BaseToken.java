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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseToken.
 * 
 * @author kosmal
 */
public abstract class BaseToken implements IToken {

	/** The data map. */
	HashMap<String, Object>	dataMap;
	
	/** The name space. */
	private final String nameSpace;
	
	/** The type. */
	private final String type;
	
	/**
	 * Instantiates a new base token.
	 * 
	 * @param nameSpace
	 *            the name space
	 * @param type
	 *            the type
	 */
	public BaseToken(final String nameSpace, final String type){
		this.nameSpace = nameSpace;
		this.type = type;
		this.dataMap = new HashMap<String, Object>();
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#clear()
	 */
	@Override
	public void clear() {
		this.dataMap.clear();
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getMap()
	 */
	@Override
	public Map<String, Object> getMap() {
		return this.dataMap;
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setMap(java.util.HashMap)
	 */
	@Override
	public void setMap(HashMap<String, Object> aMap) {
		this.dataMap = aMap;

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getObject(java.lang.String)
	 */
	@Override
	public Object getObject(String aKey) {
		return this.dataMap.get(aKey);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getString(java.lang.String, java.lang.String)
	 */
	@Override
	public String getString(String aKey, String aDefault) {
		Object lObj = this.dataMap.get(aKey);
		if (lObj instanceof String) {
			return new String(lObj.toString());
		} else {
			try {
				return String.valueOf(lObj);
			} catch (Exception e) {
				return aDefault;
			}
		}

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getString(java.lang.String)
	 */
	@Override
	public String getString(String aKey) {
		Object lObj = this.dataMap.get(aKey);
		if (lObj instanceof String) {
			return new String(lObj.toString());
		} else {
			return String.valueOf(lObj);
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setString(java.lang.String, java.lang.String)
	 */
	@Override
	public void setString(String aKey, String aValue) {
		this.dataMap.put(aKey, aValue);

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getInteger(java.lang.String, java.lang.Integer)
	 */
	@Override
	public Integer getInteger(String aKey, Integer aDefault) {
		Object lObj = dataMap.get(aKey);

		if (lObj instanceof Integer) {
			return (Integer) lObj;
		} else {
			try {
				return Integer.parseInt(lObj.toString());
			} catch (Exception e) {
				return aDefault;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getInteger(java.lang.String)
	 */
	@Override
	public Integer getInteger(String aKey) {
		return Integer.parseInt(dataMap.get(aKey).toString());
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setInteger(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void setInteger(String aKey, Integer aValue) {
		dataMap.put(aKey, aValue);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public Long getLong(String aKey, Long aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Long) {
			return (Long) lObj;
		}
		try {
			return Long.parseLong(lObj.toString());
		} catch (Exception e) {
			return aDefault;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getLong(java.lang.String)
	 */
	@Override
	public Long getLong(String aKey) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Long) {
			return (Long) lObj;
		} else {
			try {
				return Long.parseLong(lObj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setLong(java.lang.String, java.lang.Long)
	 */
	@Override
	public void setLong(String aKey, Long aValue) {
		this.dataMap.put(aKey, aValue);

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getDouble(java.lang.String, java.lang.Double)
	 */
	@Override
	public Double getDouble(String aKey, Double aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Double) {
			return (Double) lObj;
		} else {
			try {
				return Double.parseDouble(lObj.toString());
			} catch (Exception e) {
				return aDefault;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getDouble(java.lang.String)
	 */
	@Override
	public Double getDouble(String aKey) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Double) {
			return (Double) lObj;
		} else {
			try {
				return Double.parseDouble(lObj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setDouble(java.lang.String, java.lang.Double)
	 */
	@Override
	public void setDouble(String aKey, Double aValue) {
		this.dataMap.put(aKey, aValue);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setDouble(java.lang.String, java.lang.Float)
	 */
	@Override
	public void setDouble(String aKey, Float aValue) {
		this.dataMap.put(aKey, aValue);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getBoolean(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public Boolean getBoolean(String aKey, Boolean aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Boolean) {
			return (Boolean) lObj;
		} else {
			try {
				return Boolean.parseBoolean(lObj.toString());
			} catch (Exception e) {
				return aDefault;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getBoolean(java.lang.String)
	 */
	@Override
	public Boolean getBoolean(String aKey) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Boolean) {
			return (Boolean) lObj;
		} else {
			try {
				return Boolean.parseBoolean(lObj.toString());
			} catch (Exception e) {
				return null;
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setBoolean(java.lang.String, java.lang.Boolean)
	 */
	@Override
	public void setBoolean(String aKey, Boolean aValue) {
		this.put(aKey, aValue);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getList(java.lang.String, java.util.List)
	 */
	@Override
	public List<?> getList(String aKey, List<?> aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof List) {
			return (List<?>) lObj;
		} else {
			return aDefault;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getList(java.lang.String)
	 */
	@Override
	public List<?> getList(String aKey) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof List) {
			return (List<?>) lObj;
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setList(java.lang.String, java.util.List)
	 */
	@Override
	public void setList(String aKey, List<?> aList) {
		this.put(aKey, aList);

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setToken(java.lang.String, org.jwebsocket.client.util.token.Token)
	 */
	@Override
	public void setToken(String aKey, IToken aToken) {
		this.put(aKey, aToken);

	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getToken(java.lang.String)
	 */
	@Override
	public IToken getToken(String aKey) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof IToken) {
			return (IToken) lObj;
		} else {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getToken(java.lang.String, org.jwebsocket.client.util.token.Token)
	 */
	@Override
	public IToken getToken(String aKey, IToken aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof IToken) {
			return (IToken) lObj;
		} else {
			return aDefault;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getMap(java.lang.String, java.util.Map)
	 */
	@Override
	public Map<String, Object> getMap(String aKey, Map<String, Object> aDefault) {
		Object lObj = dataMap.get(aKey);
		if (lObj instanceof Map) {
			try {
				@SuppressWarnings("unchecked")
                Map<String, Object> lMap = (Map<String, Object>) lObj;

				return lMap;
			} catch (Exception e) {
				return aDefault;
			}
		} else {
			return aDefault;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#getMap(java.lang.String)
	 */
	@Override
	public Map<String, Object> getMap(String aKey) {
		Object lObj = this.dataMap.get(aKey);
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) lObj;
			return map;
		} catch (Exception e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#setMap(java.lang.String, java.util.Map)
	 */
	@Override
	public void setMap(String aKey, Map<String, Object> aMap) {
		this.dataMap.put(aKey, aMap);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#remove(java.lang.String)
	 */
	@Override
	public void remove(String aKey) {
		this.dataMap.remove(aKey);
	}

	/* (non-Javadoc)
	 * @see org.jwebsocket.client.util.token.Token#put(java.lang.String, java.lang.Object)
	 */
	@Override
	public void put(String aKey, Object aObject) {
		this.dataMap.put(aKey, aObject);
	}

	/**
	 * Gets the name space.
	 * 
	 * @return the nameSpace
	 */
    public String getNameSpace() {
	    return nameSpace;
    }

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
    public String getType() {
	    return type;
    }

	/**
     * @return the dataMap
     */
    protected final HashMap<String, Object> getDataMap() {
    	return dataMap;
    }

	/**
     * @param dataMap the dataMap to set
     */
    protected final void setDataMap(HashMap<String, Object> dataMap) {
    	this.dataMap = dataMap;
    } 
        
}
