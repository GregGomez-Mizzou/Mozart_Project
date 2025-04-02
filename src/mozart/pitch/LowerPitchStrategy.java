package mozart.pitch;

public class LowerPitchStrategy implements PitchStrategy {

	/*
	 * this implements the function in the PitchStrategy interface
	 * to lower the pitch
	 */
	
	@Override
	public int modifyPitch(int note) {
		return note - 2;
	}

}
