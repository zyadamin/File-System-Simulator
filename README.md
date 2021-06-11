# File-System-Simulator-
Assume that you have a virtual file system with a root directory called "root" all the files and folders will be stored under it.  The disk size consists of N blocks and each block size is 1 KB.

The aim of this assignment is to simulate the allocation and de-allocation of files and folders using different allocation techniques. Implement the two allocation techniques listed below (Refer to the file system chapter in your text book):

1-	Contiguous Allocation (Using Worst Fit allocation) 

2-	Indexed Allocation

3-	Linked Allocation

After running the application the user will interact with your virtual file system through a series of commands, these commands are illustrated in the table below:

System Commands:

CreateFile root/file.txt 100	

This command used to create file named “file.txt” with 100 KB size under the path “root”

Pre-requests:
1-	The path is already exist

2-	No file with the same name is already created under this path

3-	Enough space exists

CreateFolder root/folder1	

This command is used to create a new folder named “folder1” under the path “root”

Pre-requests:
1-	The path is already exist

2-	No folder with the same name is already created under this path. 

DeleteFile root/folder1/file.txt  

This command used to delete file named “file.txt” form the path "root/folder1". Any blocks allocated by this file should be de-allocated.

Pre-requests:
1-The file is already exist under the path specified 

DeleteFolder root/folder1	

This command used to delete folder named “folder1” form the path "root". All files and subdirectories of this folder will also be deleted.

Pre-requests:
1-The folder is already exist under the path specified

DisplayDiskStatus

This command used to display the status of your Driver the status should contain the following information:

1-	Empty space

2-	Allocated space

3-	Empty Blocks in the Disk

4-	Allocated  Blocks in the Disk

DisplayDiskStructure

This command will display the files and folders in your system file in a tree structure 


Saving and loading Virtual File System

In this program we are not creating actual files and folder, we will just simulate having a series of blocks and these blocks will be allocated to files when created and will be 

de-allocated when these files are deleted.

Your virtual file system information like (the files information, the folders information, the allocated blocks and so on) should be saved on a file on your hard disk to be able 

to load it the next time you run the application.

So when the application starts, the system should automatically load the disk structure form the Virtual File System file say named "c:\DiskStructure.vfs". Then the user will 

start to enter commands which will be executed on the loaded data in memory, and before the application terminates, the data in memory will be written into the file again.

Note: It’s your task to choose which structure will be used to store this file 

The following information should be stored in the file:

1-	Files and Folders Directory Structure.

2-	The Empty blocks of the virtual DISK

3-	The allocated blocks in your virtual DISK and which files/folders are take these places.

More details about these 3 points are in the following sections.

1- Files and Folders Directory Structure

The Virtual File System file should contain the structure of the files and folders which should be loaded in a tree structure in memory.  This is required to be able to print 

the tree structure when the user requests the command "DisplayDiskStructure". 

Example directory structure:

•	<root>
        
o	File0.txt
        
o	<folder1>
        
	File1.txt
        
	<folder2>
        
You should determine how to save this structure in the Virtual File System file and how to load it into Java Data Structure.
 
The Aim of this assignment is to build up a protection layer over the simple file system you’ve already created on assignment 3; the protection module will be responsible of the 

        
        following activities: 
        
1-	Creating Users 
        
2-	Assign capabilities to users: 
        
a.	 Each folder will have two capabilities Create/Delete
        
 After running the application a default user will be logged in to the system this user is called “admin” with the password “admin”, the commands in the table below will be 
        
  added to the list of the commands from assignment 3:
        
New System Commands:
        
Command	Summary
        
TellUser	
        
 This command will display the name of the current logged in user.
        
CUser ahmed pass123	
       
This command used to create user named “ahmed” with the password “pass123”.

Comments:
        
1-	only the admin can use such command 
        

Pre-requests:
        
1-	No user with the same name already created

Grant ahmed VFSD:\Folder1 10
        

Create	Delete	Comment
        
0	0	No create, No delete
        
0	1	No Create, Delete
        
1	0	Create, No Delete
        
1	1	Create, Delete
        

•	 The create capability allow the user “ahmed” to create any folder or file under the folder “VFSD:\Folder1”.

•	 The delete capability allow the user ”ahmed” to delete any folder or file under the folder “VFSD:\Folder1”.
        
        This command is used to grant the user “ahmed” Create and Delete Capabilities on the folder “VFSD:\Folder1”.

Comments: 
1-	only the admin can use such command
        
2-	This command is used for folders only
        
Pre-requests: 
1-	The path already exists 
        
2-	 The user already exists

Login ahmed pass123

•	After this command the current logged in user will be “ahmed” instead of admin.

•	 All assignment 3 commands now must be checked before its execution with the user “ahmed” capabilities.

•	Example: 

o	Right Command 
        
	CFolder Folder2 VFSD:\Folder1 
        
o	Wrong Command –
        
	DeleteFolder Folder2 VFSD:\Folder1	This command is used to change the current logged in user with the user “ahmed” 

Pre-requests: 
        
1-	The User already exists 
        
2-	The password is correct

-	The Users will be stored in a file called “user.txt” with the following format: Username , password
        
        
 Example:
        
 admin , admin 
        
-	 The capabilities will be stored in a file called capabilities.txt with the following format: Folder path , user name 1, Create and delete capability digits, user name 
        2, Create and delete capability digits, … 

Example:
 VFSD:\Folder1,admed,10,bora3y,11

  
