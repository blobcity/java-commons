# java-commons
Provides easy functions to perform several common operations on Java Collections. In future support to be added for file operations, advanced operations on Sets and Maps, and possibly inclusions for NLP, Sentiment Analysis etc.

This repository was build by BlobCity for its internal use within the BlobCity Data Platform. Due to a wide-scale requirement of such a utility, we decided to open source the project. We expect a bi-directional relationship, whereby the community can find use of the code we built, and we can find us of any code the community contributes to this repository.

This repository is actively maintained and we are open to your contributions. Write to us at support@blobcity.com if you wish to become an involved contributor and reviewer.  

## CollectionUtil
Provides high level untilty methods to easily perform some of the common operations on Java Collections.

#### CollectionUtil.retainIf
Retain all elements in collection satisfy the predicate condition
```java
CollectionUtil.retainIf(collection, a -> a > 5);
```

#### CollectionUtil.removeIf
Remove all elements in collection that satisfy the predicate condition
```java
CollectionUtil.removeIf(collection, a -> a > 5);
```

## JSON Utilities

Check if two JSON Objects are equal. Works on org.json.JSONObject or a JSON String
```java
JSON.areEqual(json1, json2)
```
Implementation does a deep check within the JSON. Checks for nested JSON's, arrays, JSON within arrays. Function will return true only if the JSONs are exactly the same. The keys don't have to be in the same order for the two JSON's to be equal. Array elements have to be in same order for the JSON's to be equal. 