package audioencoder;

import java.io.File;

public class AudioConverterService {
    private final AudioConverter audioConverter;

    public AudioConverterService(AudioConverter audioConverter) {
        this.audioConverter = audioConverter;
    }

    public void convertAudioToMP3(File source, File destination) {
        if (!source.exists()) {
            System.err.println("Audio file does not exist");
            return;
        }

        try {
            System.out.println("Starting audio conversion...");
            audioConverter.convertToMP3(source, destination);
            System.out.println("Audio conversion completed successfully. Output file: " + destination.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error converting audio: " + e.getMessage());
        }
    }
}
