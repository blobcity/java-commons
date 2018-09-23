package com.blobcity.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Provides utility functions to perform common operations on JSON objects
 *
 * @author sanketsarang
 */
public class JSON {

    public static boolean areEqual(final String json1, final String json2) throws JSONException {
        return areEqual(new JSONObject(json1), new JSONObject(json2));
    }

    public static boolean areEqual(final JSONObject json1, final JSONObject json2) {
        if(json1 == null && json2 == null) {
            return true;
        } else if(json1 == null || json2 == null) {
            return false;
        }

        for(String key : json1.keySet()) {
            if(!json2.has(key)) {
                return false;
            }

            Object json1Value = json1.get(key);
            Object json2Value = json2.get(key);

            if(json1Value instanceof JSONObject) {
                if(!(json2Value instanceof JSONObject)) {
                    return false;
                } else if (!areEqual((JSONObject) json1Value, (JSONObject) json2Value)) {
                    return false;
                }
            } else if(json1Value instanceof JSONArray) {
                if(!(json2Value instanceof JSONArray)) {
                    return false;
                } else if(!JSONArrayEquals((JSONArray) json1Value, (JSONArray) json2Value)) {
                    return false;
                }
            } else if(!json2.get(key).equals(json1.get(key))) {
                return false;
            }
        }

        return true;
    }

    private static boolean JSONArrayEquals(final JSONArray array1, final JSONArray array2) {
        if(array1.length() != array2.length()) {
            return false;
        }

        for(int i = 0; i < array1.length(); i++) {
            Object value1 = array1.get(i);
            Object value2 = array2.get(i);

            if(value1 instanceof JSONObject) {
                if(!(value2 instanceof JSONObject)) {
                    return false;
                } else if (!areEqual((JSONObject) value1, (JSONObject) value2)) {
                    return false;
                }
            } else if(value1 instanceof JSONArray) {
                if(!(value2 instanceof JSONArray)) {
                    return false;
                } else if(!JSONArrayEquals((JSONArray) value1, (JSONArray) value2)) {
                    return false;
                }
            } else if (!value1.equals(value2)) {
                return false;
            }
        }

        for(int i = 0; i < array2.length(); i++) {
            Object value1 = array1.get(i);
            Object value2 = array2.get(i);

            if(value2 instanceof JSONObject) {
                if(!(value1 instanceof JSONObject)) {
                    return false;
                } else if (!areEqual((JSONObject) value2, (JSONObject) value1)) {
                    return false;
                }
            } else if(value2 instanceof JSONArray) {
                if(!(value1 instanceof JSONArray)) {
                    return false;
                } else if(!JSONArrayEquals((JSONArray) value2, (JSONArray) value1)) {
                    return false;
                }
            } else if (!value2.equals(value1)) {
                return false;
            }
        }

        return true;
     }
}
