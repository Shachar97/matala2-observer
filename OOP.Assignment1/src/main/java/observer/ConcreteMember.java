package observer;

public class ConcreteMember implements Member {

    /**
     * state is the current state of member
     */
    public UndoableStringBuilder state;

    /**
     * check_reg is 1 if the ConcreteMember is register to a groupAdmin else 0
     */
    public int check_reg;

    /**
     * constructor
     */
    public ConcreteMember(){
        check_reg=0;
    }

    /**
     * update state to be usb
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        state=usb;
    }
}
