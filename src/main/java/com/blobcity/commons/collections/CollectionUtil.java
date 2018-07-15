package com.blobcity.commons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Provides high level utility methods for most common operations performed on Collections
 *
 * @author sanketsarang
 */
public class CollectionUtil {

    /**
     * Retains elements in a collection that satisfy the Predicate condition. A value of <code>true</code> returned
     * by Predicate indicates that the specific element must be retained.
     * @param collection a collection implementation
     * @param predicate the predicate function to apply for selecting the elements to be retained
     * @param <T> class type
     */
    public static <T> void retainIf(Collection<T> collection, Predicate<? super T> predicate) {
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()) {
            T item = iterator.next();
            if(!predicate.test(item)) {
                iterator.remove();
            }
        }
    }

    /**
     * Removes elements in a collection that satisify the Predicate condiction. A value of <code>true</code> returned
     * by predicate indciates that the specific elements must be removed.
     * @param collection a collection implementation
     * @param predicate the predicate function to apply for selecting the elemnents to be removed
     * @param <T> class type
     */
    public static <T> void removeIf(Collection<T> collection, Predicate<? super T> predicate) {
        Iterator<T> iterator = collection.iterator();
        while(iterator.hasNext()) {
            T item = iterator.next();
            if(predicate.test(item)) {
                iterator.remove();
            }
        }
    }
}
