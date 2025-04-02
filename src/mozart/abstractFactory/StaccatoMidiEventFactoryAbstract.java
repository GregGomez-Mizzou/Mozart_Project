package mozart.abstractFactory;

import mozart.midiEventFactory.MidiEventFactory;
import mozart.midiEventFactory.StaccatoMidiEventFactory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventAbstractFactory {
    
	/*
	 * This abstract factory uses the base abstract factory to create
	 * a staccato version that differs from the others while remaining as
	 * the same type of data
	 */
	
	@Override
    public MidiEventFactory createFactory() {
        return new StaccatoMidiEventFactory();
    }
}