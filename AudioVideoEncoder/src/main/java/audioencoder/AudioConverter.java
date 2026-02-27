package audioencoder;

import java.io.File;

public interface AudioConverter {
    void convertToMP3(File source, File destination) throws Exception;
}
