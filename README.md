1- Description of the work

1.1 File System

In this coursework we are going to develop an extensible object-oriented data structure for
managing files, folders, and links to files and folders. Every file will have its name and size
recorded. Every folder may contain files, other folders and links. A  file (folder) link is just a
pointer to another file (respectively, folder). Creating a link has the effect of giving a file or
folder multiple names (e.g., different names in different folders) all of which independently
connect to the same data on the disk; this causes an alias effect: e.g., if the file is opened
by any one of its names, and changes are made to its content, then these changes will also
be visible when the file is opened by an alternative name.

1.2  Coursework3Main

The main method of the class Coursework3Main uses several of the methods in the classes
that implement the Entry interface. However, this is not really proper unit testing: unit
tests should not rely on a particular execution order, and we cannot check conveniently
whether the results of the computations are as expected.
Thus, you need to create a class EntryTest as a test suite with the tests listed below,
in the format of JUnit version 4 that we used in the lecture. Use the most suitable JUnit
assertions for the tested property.
