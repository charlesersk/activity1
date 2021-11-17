package taskone;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class StringList {
    
    List<String> strings = new ArrayList<String>();

    public void add(String str) {
        int pos = strings.indexOf(str);
        if (pos < 0) {
            strings.add(str);
        }
    }

    public String remove(int position) {
        try {
            return strings.remove(position);
        } catch (Exception exception) {
            return null;
        }
    }

    public String reverse(int start, int end) {
        if (start < 0 || start >= strings.size() || end < 0 || end >= strings.size() || end < start) {
            return null;
        }
        List<String> subList = this.strings.subList(start, end + 1);
        Collections.reverse(subList);
        return subList.toString();
    }

    public boolean contains(String str) {
        return strings.indexOf(str) >= 0;
    }

    public int size() {
        return strings.size();
    }

    public String toString() {
        return strings.toString();
    }
}