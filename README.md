# AddressBook Project

## Overview

>   In a previous project, you created a **Contact** class that will eventually
>   become part of a customized **Address Book** application. An object of the
>   **Contact** class represented all information about one individual contact.
>   The intent of this assignment is to expand on that project to permit
>   maintaining a collection of multiple contacts. Central to this goal is the
>   creation of an **AddressBook** class that maintains an internal **ArrayList
>   \<Contact\>** and the modification (or replacement of) the original driver
>   program to permit thorough testing and demonstration of the program
>   modifications.

## Specifications

>   The **driver class** should have a main menu that includes at least the
>   following choices.

1.  Import contacts from a file

2.  Create and add a new Contact to AddressBook

3.  Edit an existing Contact and update the AddressBook

4.  Remove a Contact from the AddressBook by name

5.  Display all Contacts from the AddressBook

6.  Find and display a Contact by name in the AddressBook

7.  Display all Contacts of a given ContactType

8.  Display all Contacts that are in a specified zip code

9.  Sort the Contacts in the AddressBook by name

10. Exit

>   The **AddressBook** class should have at least the following **private
>   attributes**, but you may add as many others as needed:

-   **ArrayList \<Contact\>**

-   A special **Contact** named **owner** that represents the individual owner
    of the **AddressBook**. This will be the user of the program who gives
    his/her name when welcomed to the program.

>   In addition to the usual constructors, getters, setters, and **toString**
>   methods, the **AddressBook** class will need the methods required to support
>   the functionality required in the driver (searching, sorting, retrieving a
>   **Contact**, adding a **Contact**, and so forth).

>   *Note*: The **AddressBook** class contains a *PRIVATE*
>   **ArrayList\<Contact\>**. Since the **ArrayList** is private, its methods
>   are NOT ACCESSIBLE from the **driver** or any other class. You will need to
>   add **public** methods such as **get**, **set**, **size**, and **remove** to
>   **AddressBook** class so they can be used from outside of **AddressBook** to
>   access the necessary features of the encapsulated **ArrayList**.

>   Test the program with **at least 10 Contact** objects of varying
>   **ContactTypes**. Otherwise, you will not be assured that all sorting and
>   searching methods have been completely tested. This information should be in
>   a txt file that can be read in

>   by the driver if that option is chosen. The user must be able to choose the
>   file to be read in (using JFileChooser). If the contacts have been changed
>   in any way, you are to write out the updated address book to a file (again
>   using JFileChooser) before the program closes. In your design document, be
>   sure to provide the complete list of **Contact** information to be used in
>   testing.

>   You must handle all exceptions in processing. Simply adding a throws
>   Exception clause to the methods inside the driver does not count as
>   “handling the exceptions”.
