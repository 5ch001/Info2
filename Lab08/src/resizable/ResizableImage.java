package resizable;

import java.awt.*;

public interface ResizableImage {
    Image getImage(Dimension size);
    Image getResizeImage(Dimension size);
}
