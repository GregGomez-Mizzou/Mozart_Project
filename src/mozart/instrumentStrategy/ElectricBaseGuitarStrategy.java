package instrumentStrategy;
import javax.sound.midi.*;

public class ElectricBaseGuitarStrategy implements InstrumentStrategy {

	@Override
	public void applyInstrument(Track track, int channel) {
		
		/*
		 * This function implements the instrument strategy and applies the use of the instrument
		 */
		
		try {
            ShortMessage programChange = new ShortMessage();
            programChange.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 34, 0);
            MidiEvent changeInstrument = new MidiEvent(programChange, 0);
            track.add(changeInstrument);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
	}

}
