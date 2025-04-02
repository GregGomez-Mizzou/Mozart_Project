package mozart.abstractFactory;

import mozart.midiEventFactory.LegatoMidiEventFactory;
import mozart.midiEventFactory.MidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventAbstractFactory {
	
	/*
	 * This abstract factory uses the base abstract factory to create
	 * a legato version that differs from the others while remaining as
	 * the same type of data
	 */
	
    @Override
    public MidiEventFactory createFactory() {
        return new LegatoMidiEventFactory();
    }
}