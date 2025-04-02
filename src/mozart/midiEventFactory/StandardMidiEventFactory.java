package mozart.midiEventFactory;
import javax.sound.midi.*;


import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public class StandardMidiEventFactory implements MidiEventFactory {
	
	@Override
    public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
        ShortMessage sm = new ShortMessage();
        sm.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
        return new MidiEvent(sm, tick);
    }

	
	/**
	 * This implements the event factory so that the code can stay dynamic while
	 * changing different settings. This version makes the off tick standard.
	 */
	
    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage sm = new ShortMessage();
        sm.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(sm, tick);
    }

}
