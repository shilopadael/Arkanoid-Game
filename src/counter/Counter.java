package counter;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */

public class Counter {

    private final String name;     // counter name
    private  int maxCount;    // maximum value
    private int count;             // current value

    // create a new counter with the given parameters

    /**
     * Counter Class.
     * @param id String.
     * @param max int(Max integer to count).
     */
    public Counter(String id, int max) {
        name = id;
        maxCount = 10000;
        count = 0;
    }

    /**
     * add number to current count.
     * @param number int.
     */
    public void increase(int number) {
        if (count < maxCount) {
            count += number;
        }

    }

    /**
     * subtract number from current count.
     * @param number int.
     */
    public void decrease(int number) {
        if (count > 0) {
            count -= number;
        }
    }
    // get current count.
    int getValue() {
        return count;
    }

    /**
     * get Name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * get count.
     * @return int.
     */
    public int getCount() {
        return count;
    }
}