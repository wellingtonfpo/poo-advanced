package audioencoder;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

import java.io.File;

public class JaveAudioConverterFacade implements AudioConverter{
    @Override
    public void convertToMP3(File source, File destination) throws Exception {
        AudioAttributes audioAttributes = new AudioAttributes();
        audioAttributes.setCodec("libmp3lame");
        audioAttributes.setBitRate(48000);
        audioAttributes.setChannels(2);
        audioAttributes.setSamplingRate(44100);

        EncodingAttributes encodingAttributes = new EncodingAttributes();
        encodingAttributes.setOutputFormat("mp3");
        encodingAttributes.setAudioAttributes(audioAttributes);

        Encoder encoder = new Encoder();
        encoder.encode(new MultimediaObject(source), destination, encodingAttributes);
    }
}
