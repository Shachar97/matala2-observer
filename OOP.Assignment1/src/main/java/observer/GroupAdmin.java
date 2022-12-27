package observer;

import java.util.ArrayList;

public class GroupAdmin implements  Sender {

    /**
     * myMember is data structure that contain the members that registered
     */
    public ArrayList <Member> myMembers;
    /**
     * state is the current state of group admin
     */
    public UndoableStringBuilder state;

    /**
     * constructor
     */
    public  GroupAdmin() {
        state=new UndoableStringBuilder();
        myMembers=new ArrayList<>();

    }

    /**
     * if obj not already in myMember insert obj into myMember and update it's state to the state of the groupAdmin
     */
    @Override
    public void register(Member obj){
        if(((ConcreteMember) obj).check_reg == 0){
            this.myMembers.add(obj);
            ((ConcreteMember) obj).check_reg++;
            ((ConcreteMember) obj).state=this.state;
        }
        else {
            System.out.println("already in the system");
        }

    }

    /**
     *take out obj out of myMember and change it's state to null
     */
    @Override
    public void unregister(Member obj){
        obj.update(null);
        this.myMembers.remove(obj);
        ((ConcreteMember) obj).check_reg--;
    }

    /**
     * insert obj into state in index offset
     */
    @Override
    public void insert(int offset, String obj){
        state.insert(offset,obj);
        Notify();
    }

    /**
     *append obj into state
     */
    @Override
    public void append(String obj) {
        state.append(obj);
        Notify();
    }

    /**
     *delete in state from index start to end
     */
    @Override
    public void delete(int start, int end) {
        state.delete(start,end);
    }

    /**
     * change state into the previous state
     */
    @Override
    public void undo() {
        state.undo();
        Notify();
    }

    /**
     * notify all the members in myMembers about the new state
     */
    public void Notify(){
        int i=0;
        while(i<myMembers.size()){
            myMembers.get(i).update(state);
            i++;
        }
    }

    /**
     *return the current state
     */
    public String state_toString(){
        return state.toString();
    }


}