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

    @Override
    public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
        ShortMessage sm = new ShortMessage();
        sm.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);
        return new MidiEvent(sm, tick);
    }

}
