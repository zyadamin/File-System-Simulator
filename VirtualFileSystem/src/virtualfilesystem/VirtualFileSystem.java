/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualfilesystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Manar Atef
 */
public class VirtualFileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Alocation_techniques allocate = null;
      Manger manger=new Manger();
      Directory root=new Directory();
      root.setDirectoryPath("root");        
      
       int disk[];  
       int size;
       Scanner input= new  Scanner(System.in);
       
        System.out.println("Enter disk size");
        size= input.nextInt();
        
 
        disk= new int[size];
       
 
        System.out.println("what is the allocation technique");
        System.out.println("1-Contiguous Allocation\n"
                           + "2-Linked Allocation\n"
                           + "3-Indexed Allocation\n");
        
        
        int type=input.nextInt();
       
        if(type==1){
        allocate= new ContiguousAllocation();
        
        }
        else if(type==2){
        allocate= new LinkedAllocation();
        
        }
        else if(type==3){
        
        allocate=new IndexedAllocation();
        
        }
        
        String command="";
        
        while(true){
            
            System.out.print("\n$");
            command=input.next();
            
            
        if(command.equalsIgnoreCase("CreateFile")){
         String name=input.next();
         int fileSize=input.nextInt();
         manger.createFile(root,name,fileSize,allocate , disk);
         
        }
        
        else if(command.equalsIgnoreCase("CreateFolder")){
         String name=input.next();
        
        manger.creatFolder(root, name);
        }
        
        else if(command.equalsIgnoreCase("DeleteFile")){
                 String name=input.next();
                 manger.DeleteFile(root, name, disk, allocate);
        
        
        
        
        }
        
        else if(command.equalsIgnoreCase("DeleteFolder")){
                 String name=input.next();
                 manger.DeleteFolder(root, name,disk,allocate);
        
        }


        else if(command.equalsIgnoreCase("DisplayDiskStatus")){
            ArrayList<Integer>empty=new ArrayList<>();
            ArrayList<Integer>Allocated=new ArrayList<>();
        
        for(int i=0;i<disk.length;i++){
        if(disk[i]==0){empty.add(i);}
        else{Allocated.add(i);}
        }
        
        
            System.out.println("Empty space: " +empty.size());
            System.out.println("Allocated  space: " +Allocated.size());
 
            System.out.println("Empty Blocks in the Disk");
            for(int i=0;i<empty.size();i++){
              System.out.print(empty.get(i)+" ");
          }  
            
        
         System.out.println("Allocated  Blocks in the Disk");
         for(int i=0;i<Allocated.size();i++){
              System.out.print(Allocated.get(i)+" ");
          }  
             
          
        }

        else if(command.equalsIgnoreCase("DisplayDiskStructure")){
        
                root.printDirectoryStructure(root);
        
        }

        }
        
    }
    
}
/*
CreateFile root/file.txt 100
CreateFolder root/folder1
DeleteFile root/folder1/file.txt  
DeleteFolder root/folder1	
DisplayDiskStatus
DisplayDiskStructure

*/