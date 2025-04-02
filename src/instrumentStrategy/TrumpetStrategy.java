package instrumentStrategy;
import javax.sound.midi.*;

public class TrumpetStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel) {
		try {
            ShortMessage programChange = new ShortMessage();
            programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
            MidiEvent changeInstrument = new MidiEvent(programChange, 0);
            track.add(changeInstrument);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
	}

}
