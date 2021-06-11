/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualfilesystem;

/**
 *
 * @author Manar Atef
 */
public class Manger {
    
     private Alocation_techniques techniq;
     private Directory palce;
    public Alocation_techniques getTechniq() {
        return techniq;
    }

    public void setTechniq(Alocation_techniques techniq) {
        this.techniq = techniq;
    }
     
    public void createFile(Directory curr,String path,int size ,Alocation_techniques techniq,int disk[]){
      
    //check file find or no
    if(checkFile(curr,path)){ //not find
        //allocation new file
        int index = 0;
       
        for(int i=0;i<path.length();i++){
       if(path.charAt(i)=='/'){index=i;}
       }
       path=path.substring(index+1,path.length());  
    File newOne = techniq.Allocation(disk, path, size);
    
    if(newOne==null){
        
    System.out.println("disk capacity is low ");
    
    }
    else{
    this.palce.getFiles().add(newOne);
    
        System.out.println("file created");
    
    }}
    else{
    
        System.out.println("fiald to create file");
    }
    
    
    }
    

public boolean checkFile(Directory curr,String name){
   //root/folder/file.txt
   
    int find=name.indexOf('/');
    name=name.substring(find+1, name.length()); 
    
   int countBack=0;
   int count=0;
   for(int i=0;i<name.length();i++){
   
   if(name.charAt(i)=='/'){countBack++;}
   }
   
   
   if(countBack==0){
      this.palce=curr;
   for(int i=0;i<curr.getFiles().size();i++){

    if(name.equals(curr.getFiles().get(i).getFilePath())){
    count++;
    }
  }
   
   if(count>0){return  false;}
   }
   
   else{
       Directory newOne=null;
       find=name.indexOf('/');
      String folder=name.substring(0, find);
       
      for(int i=0;i<curr.getSubDirectories().size();i++){
      
      if(folder.equals(curr.getSubDirectories().get(i).getDirectoryPath())){
         newOne=curr.getSubDirectories().get(i);
         break;
      }
      }
      
      if(newOne!=null){
       checkFile(newOne, name);
      }
      else{return false;}
   }
   

return  true;

}


public void creatFolder(Directory curr,String path){

     //root/folder1/folder2
     
    //check file find or no
    if(checkFolder(curr,path)){ //not find
        //allocation new file
       int index = 0;
       for(int i=0;i<path.length();i++){
       if(path.charAt(i)=='/'){index=i;}
       }
       path=path.substring(index+1,path.length());  
   
      Directory newOne= new Directory();
      newOne.setDirectoryPath(path);
      this.palce.getSubDirectories().add(newOne);
    
        System.out.println("folder created");
    }
    
    
    else{
    
        System.out.println("fiald to create folder");
    }
    

}


public boolean checkFolder(Directory curr,String name){

 
    int find=name.indexOf('/');
    name=name.substring(find+1, name.length()); 
    
   int countBack=0;
   int count=0;
   for(int i=0;i<name.length();i++){
   
   if(name.charAt(i)=='/'){countBack++;}
   }
   
   
   if(countBack==0){
      this.palce=curr;
   for(int i=0;i<curr.getSubDirectories().size();i++){

    if(name.equals(curr.getSubDirectories().get(i).getDirectoryPath())){
    count++;
    }
  }
   
   if(count>0){return  false;}
   }
   
   else{
       Directory newOne=null;
       find=name.indexOf('/');
      String folder=name.substring(0, find);
       
      for(int i=0;i<curr.getSubDirectories().size();i++){
      
      if(folder.equals(curr.getSubDirectories().get(i).getDirectoryPath())){
         newOne=curr.getSubDirectories().get(i);
         break;
      }
      }
      
      if(newOne!=null){
       checkFolder(newOne, name);
      }
      else{return false;}
   }
   

return  true;




}

public void DeleteFile(Directory curr,String path,int disk[],Alocation_techniques techniq){
  if(!checkFile(curr,path)){
      System.out.println("virtualfilesystem.Manger.DeleteFile()");
       int index = 0;
       for(int i=0;i<path.length();i++){
       if(path.charAt(i)=='/'){index=i;}
       }
       path=path.substring(index+1,path.length());  
   
      for(int i=0;i<palce.getFiles().size();i++){
      if(this.palce.getFiles().get(i).getFilePath().equals(path)){
      techniq.DeAllocation(this.palce.getFiles().get(i), disk);
       this.palce.getFiles().remove(i);
      }
              }
     
  
  }
  else{
      System.out.println(" the file not found");
  }


}
public void DeleteFolder(Directory curr,String path,int disk[],Alocation_techniques techniq){
  if(!checkFolder(curr,path)){
      //root/folder1/folder2
      System.out.println(palce.getDirectoryPath()+"545454");
       int remove=0;
       int index = 0;
       for(int i=0;i<path.length();i++){
       if(path.charAt(i)=='/'){index=i;}
       }
       String comp=path.substring(index+1,path.length());  
      
        for(int i=0;i<palce.getSubDirectories().size();i++){
        
            if(palce.getSubDirectories().get(i).getDirectoryPath().equals(comp)){
            palce=palce.getSubDirectories().get(i);
            remove=i;
            }
        }
      
  for(int i=0;i<palce.getFiles().size();i++){
  String newOne=palce.getFiles().get(i).getFilePath();
  String data =path+"/"+newOne;
  System.out.println(data);
  DeleteFile(curr, data, disk, techniq);
  }
  
  for(int i=0;i<palce.getSubDirectories().size();i++){
   String newOne=palce.getSubDirectories().get(i).getDirectoryPath();
   String data =path+"/"+newOne;
   DeleteFolder(curr, data, disk, techniq);
  }
  
      checkFolder(curr, path);
      
      palce.getSubDirectories().remove(remove);
      
      
      
  
  }
  else{System.out.println("folder is not found");}
}



//root/folder1/folder2

}
