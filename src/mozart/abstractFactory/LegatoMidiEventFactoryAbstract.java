package mozart.abstractFactory;

import mozart.midiEventFactory.LegatoMidiEventFactory;
import mozart.midiEventFactory.MidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventAbstractFactory {
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}