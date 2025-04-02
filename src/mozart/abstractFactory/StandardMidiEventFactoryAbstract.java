package mozart.abstractFactory;
import mozart.midiEventFactory.MidiEventFactory;
import mozart.midiEventFactory.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventAbstractFactory {
	
	/*
	 * This abstract factory uses the base abstract factory to create
	 * a standard version that differs from the others while remaining as
	 * the same type of data
	 */
	
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}