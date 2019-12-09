package sample;

/**
 * @author Kevin
 *
 * AudioPlayer extends Product implements MultimediaControl
 */
public class AudioPlayer extends Product implements MultimediaControl {
    String audioSpecification;
    String mediaType;

    /**
     *
     * @param name String
     * @param manufacturer String
     * @param mediaType String
     * @param audioSpecification String
     */
    public AudioPlayer(
            String name, String manufacturer, String mediaType, String audioSpecification) {

        super(name, manufacturer, ItemType.AUDIO);

        this.audioSpecification = audioSpecification;
        this.mediaType = mediaType;
    } // constructor

    public String getAudioSpecification() {
        return this.audioSpecification;
    } // getaudioSpecification

    public String getMediaType() {
        return this.mediaType;
    } // getmediaType

    public void setAudioSpecification(String audioSpecification) {
        this.audioSpecification = audioSpecification;
    } // setsudioSpecification

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    } // setmediaType

    public void play() {
        System.out.println("Playing");
    }

    public void stop() {
        System.out.println("Stopping");
    }

    public void previous() {
        System.out.println("Previous");
    }

    public void next() {
        System.out.println("Next");
    }

    /**
     * format String
     * @return String
     */
    public String toString() {
        return String.format(
                "%s\nSupported Audio Formats: %s\nSupported Playlist Formats: %s",
                super.toString(), this.mediaType, this.audioSpecification);
    }
} // class