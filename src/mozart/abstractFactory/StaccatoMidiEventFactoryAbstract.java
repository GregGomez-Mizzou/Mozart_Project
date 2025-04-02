package mozart.abstractFactory;

import mozart.midiEventFactory.MidiEventFactory;
import mozart.midiEventFactory.StaccatoMidiEventFactory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventAbstractFactory {
    @Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}