package moe.emilia.relearn.utils;

import java.util.List;

/**
 * @author lihuaye
 */
public class ListUtils {

    public static <E> boolean isEquals(List<E> first, List<E> second) {
        if (first.size() != second.size()) {
            return false;
        }

        for (int i = 0; i < first.size(); i++) {
            if (!first.get(i).equals(second.get(i))) {
                return false;
            }
        }

        return true;
    }
}
