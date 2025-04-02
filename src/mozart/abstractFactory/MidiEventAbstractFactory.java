package mozart.abstractFactory;

import mozart.midiEventFactory.MidiEventFactory;

public interface MidiEventAbstractFactory {
	
	MidiEventFactory createFactory();
	
}
