package notification;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl HitListener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl HitListener
     */
    void removeHitListener(HitListener hl);
}