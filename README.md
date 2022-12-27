# matala2-observer
 
**instuction:**
open folder OOP.Assignment1/src
the java classes are in folders main/java/observer
the tests are in folders test/java

**GroupAdmin:**
his fileds are ArrayList that hold all his member types, and UndoableStringBiulder (USB), that we biuld in the previus work.

every member we include with the function register, we apdate his USB in shallow coppy,  so any apdate that we make in our USB is outomaticly happend in every member in the list.

to unregest a member we need to cutt his shallow coppy and make it to NULL.

all the ather function are using the functionality of the USB.
the notify function is goes over all the mambers in the list and make a shallow coppy of USB.

**ConcrentMember:**
his fileds are USB, and Integer that holds 1 if the member is regist or 0 when the member is unregist.
the function update make a shadow coppy of the wanted USB.

**UndoableStringBiulder**
the fileds: StringBiulder of java, and Stack that hold StringBiulder types.
all his functionallity using the function from StringBuilder of java with adding to the stack the last StringBuilder, so when we wont to use the undo function we return the last StringBuilder in the stack and pop it out.
