package mozart.abstractFactory;
import mozart.midiEventFactory.MidiEventFactory;
import mozart.midiEventFactory.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventAbstractFactory {
    @Override
    public MidiEventFactory createFactory() {
        return new StandardMidiEventFactory();
    }
}