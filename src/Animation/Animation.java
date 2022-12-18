package Animation;

import biuoop.DrawSurface;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public interface Animation {
    /**
     * doing one frame.
     * @param d DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * @return boolean.
     */
    boolean shouldStop();
}