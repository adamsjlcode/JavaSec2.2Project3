**Computer Science 1260 – Project 3**

>   March 21, 2016 Class Roll Manager Due: \_______________\_

**Overview**

In **Project 1**, you created a **Student** class that will eventually become
part of a customized **Class Roll Manager** application. An object of the
**Student** class represented all information we needed about one individual
student. The intent of this **Project** is to expand the **first Project** to
maintain and manage a collection of **Student** objects. You will create a new
class name **RollManager** that maintains an **internal ArrayList \<Student\>**
named **classRoll** and provides methods that manage the collection to provide
the capabilities required by the **specifications** that follow. In addition,
you will replace the **Driver** class from **Project 1** with a new **Driver**
with expanded capabilities as described below. You will continue to use
**Classification** and **Student** that you developed for **Project 1**.

Be sure to test the new program thoroughly and verify that it does everything
required correctly.

**Specifications**

The **driver class** should have a **main menu** that includes at least the
following choices.

1.  **Create** a new **Course** for the **Class Roll Manager**

2.  **Create** a new **Student** object and add it to the **RollManager’s
    classRoll**

3.  **Edit** an existing **Student** from the **RollManager’s classRoll**

4.  **Drop** a **Student** from the **classRoll**

5.  **Display** all **Students** on the **classRoll**

6.  Find and display a **Student** by **name**

7.  **Display** all **Students** on the **classRoll** of a given
    **Classification**

8.  **Sort** the **Students** by **name** (**last, first**)

9.  **Sort** the **Students** by **GPA**

10. Exit

The **RollManager** class should have at least the following **private
attributes**, but you may add others as needed.

-   **ArrayList \<Student\>** named **classRoll**

-   **String** named **courseNumber** containing the course and section
    information such as **CSCI 1260-090**

-   **String** named **courseName** containing the name of the course such as
    **Introduction to Computer Science II**

-   **String** named **instructor** containing the name of the **course
    instructor**

In addition to the usual **constructors**, **getters**, **setters**, and
**toString** methods, the **RollManager** class must have all of the methods
required to support the functionality needed in the driver class (**searching**,
**sorting**, **retrieving**, **adding**, **dropping**, **editing**, etc.)

Since the **classRoll** is a **private ArrayList** inside **RollManager**, it
can only be accessed by the **RollManager** class. The **driver** class
**cannot** directly access any **Student** on the **classRoll**. Thus, the
**RollManager** class will have to provide methods such as **get**, **set**,
**size**, and **remove** so that the **driver** can work with individual
**Students** from **classRoll**.

Project 3 – Class Roll Manager Page 1

**Computer Science 1260 – Project 3**

>   March 21, 2016 Class Roll Manager Due: \_______________\_

**Testing the Code**

Your **test suite** in your **design document** should contain at least **7
Students** – one for each **Classification type** and one other that has an
invalid **Classification**. It may contain more **Students**. You should test
your program with all of the inputs in your design document.

**Other Project Requirements**

Please read the *Software Engineering Code of Ethics and Professional Practice*
found at <http://www.acm.org/about/se-code/> as it relates to **principle 3**,
the product (short form in Preamble and more details in the body of the
document). In consideration of this project, are there any ethical issues you
should consider as they relate to what you have read? Please state your answer
in a Microsoft Word document as concisely as possible. **Format, spelling,
grammar, and so forth count.**

**Submit this answer as a separate section of your initial design document**.

**Deliverables**

Follow the instructions posted to D2L. Due dates are posted on the course
calendar.

Project 3 – Class Roll Manager Page 2
