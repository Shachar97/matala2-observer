# matala2-observer
 
## instuction:
the code files in folders OOP.Assignment1/src
the java classes are in folders main/java/observer.
the tests are in folders test/java.

## interfaces:
Member: for object classes that we want to 


## GroupAdmin:
implement from Sender interface, his fields are ArrayList that hold all his member types, and UndoableStringBuilder (USB), that we build in the previous work.

every member we include with the function register, we update his USB in shallow-copy,  so any update that we make in our USB is automatically happened in every member in the list.

to unregister a member we need to cut his shallow-copy and make it to NULL.

all the other function are using the functionality of the USB.
the notify function is goes over all the members in the list and make a shallow-copy of USB.

## ConcreteMember:
implement from Member interface, his fields are USB, and Integer that holds 1 if the member is register or 0 when the member is unregister.
the function update make a shadow-copy of the wanted USB.

## UndoableStringBuilder:
the fields: StringBuilder of java, and Stack that hold StringBuilder types.
all his functionality using the function from StringBuilder of java with adding to the stack the last StringBuilder, so when we wont to use the undo function we return the last StringBuilder in the stack and pop it out.

