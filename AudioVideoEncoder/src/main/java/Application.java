import encoder.audio.*;

void main() {
    File sourceFile = new File("audio.m4a");
    File targetFile = new File("audio.mp3");

    //AudioEncoder audioEncoder = new AudioEncoder();
    //audioEncoder.encode(sourceFile, targetFile);

    AudioConverter audioConverter = new JaveAudioConverterFacade();
    AudioConverterService audioConverterService = new AudioConverterService(audioConverter);
    audioConverterService.convertAudioToMP3(sourceFile, targetFile);
}
