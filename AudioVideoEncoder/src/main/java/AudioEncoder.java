import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

import java.io.File;

public class AudioEncoder {
    public void encode(File sourcePath, File targetPath) {
        try {
            AudioAttributes audioAttributes = new AudioAttributes();
            audioAttributes.setCodec("libmp3lame");
            audioAttributes.setBitRate(48000);
            audioAttributes.setChannels(2);
            audioAttributes.setSamplingRate(44100);

            EncodingAttributes encodingAttributes = new EncodingAttributes();
            encodingAttributes.setOutputFormat("mp3");
            encodingAttributes.setAudioAttributes(audioAttributes);

            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(sourcePath), targetPath, encodingAttributes);

            System.out.println("Audio encoding successful! Output file: " + targetPath.getAbsolutePath());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Encoding failed: " + e.getMessage());
        }
    }
}
